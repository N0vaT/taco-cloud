package com.nova.tacocloud.dao;

import com.nova.tacocloud.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    List<Ingredient> findByType(Ingredient.Type type);
}
