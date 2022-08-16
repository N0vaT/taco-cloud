package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.IngredientRepository;
import com.nova.tacocloud.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public Iterable<Ingredient> findAll(){
        return ingredientRepo.findAll();
    }

    public List<Ingredient> filterByType(Ingredient.Type type) {
        return ingredientRepo.findByType(type);
    }
}
