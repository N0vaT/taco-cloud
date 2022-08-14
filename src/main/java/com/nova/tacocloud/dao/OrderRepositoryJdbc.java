package com.nova.tacocloud.dao;

import com.nova.tacocloud.domain.Ingredient;
import com.nova.tacocloud.domain.IngredientRef;
import com.nova.tacocloud.domain.Taco;
import com.nova.tacocloud.domain.TacoOrder;
import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepositoryJdbc implements OrderRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public OrderRepositoryJdbc(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder tacoOrder) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO Taco_Order " +
                        "(delivery_name, delivery_street, delivery_city, " +
                        "delivery_state, delivery_zip, cc_number, " +
                        "cc_expiration, cc_CVV, placed_at) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);

        tacoOrder.setPlacedAt(LocalDateTime.now());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        tacoOrder.getDeliveryName(),
                        tacoOrder.getDeliveryStreet(),
                        tacoOrder.getDeliveryCity(),
                        tacoOrder.getDeliveryState(),
                        tacoOrder.getDeliveryZip(),
                        tacoOrder.getCcNumber(),
                        tacoOrder.getCcExpiration(),
                        tacoOrder.getCcCVV(),
                        tacoOrder.getPlacedAt()));
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        tacoOrder.setId(orderId);

        List<Taco> tacos = tacoOrder.getTacos();
        int i = 0;
        for (Taco taco : tacos){
            saveTaco(orderId,i++,taco);
        }
        return tacoOrder;
    }

    private long saveTaco(long orderId, int orderKey, Taco taco) {
        taco.setCreatedAt(LocalDateTime.now());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "INSERT INTO Taco " +
                        "(name, taco_order, taco_order_key, created_at) " +
                        "VALUES (?, ?, ?, ?)", Types.VARCHAR, Type.LONG, Type.LONG, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(taco.getName(),
                        orderId,
                        orderKey,
                        taco.getCreatedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();

        saveIngredientRefs(tacoId, taco.getIngredients());

        return tacoId;
    }

    private void saveIngredientRefs(long tacoId, List<Ingredient> ingredients) {
        int key = 0;
        for (Ingredient ingredient:ingredients){
            jdbcOperations.update(
                    "INSERT INTO Ingredient_Ref (ingredient, taco, taco_key) " +
                            "VALUES (?, ?, ?)", ingredient.getId(), tacoId, key++);
        }
    }
}
