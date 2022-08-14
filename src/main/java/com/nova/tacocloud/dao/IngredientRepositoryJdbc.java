package com.nova.tacocloud.dao;

import com.nova.tacocloud.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryJdbc implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient",
//                new RowMapper<Ingredient>() {
//                    @Override
//                    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        return new Ingredient(rs.getString("id"),
//                                rs.getString("name"),
//                                Ingredient.Type.valueOf(rs.getString("type")));
//                    }
//                });
        this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id){
        List<Ingredient> result = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient, id);
        return result.size()==0?Optional.empty():Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type")));
    }

}