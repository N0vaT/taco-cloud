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

    @Transactional(readOnly = true)
    public Iterable<Ingredient> findAll(){
//        List<Ingredient> ingredients = Arrays.asList(
//                new Ingredient("FLTO", "Мучная лепешка", Ingredient.Type.WRAP),
//                new Ingredient("COTO", "Кукурузная лепешка", Ingredient.Type.WRAP),
//                new Ingredient("GRBF", "Говяжий фарш", Ingredient.Type.PROTEIN),
//                new Ingredient("CARN", "Котлета", Ingredient.Type.PROTEIN),
//                new Ingredient("TMTO", "Салат", Ingredient.Type.VEGGIES),
//                new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE),
//                new Ingredient("JACK", "Сыр Джек", Ingredient.Type.CHEESE),
//                new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE),
//                new Ingredient("SRCR", "Сметана", Ingredient.Type.SAUCE)
//        );
        return ingredientRepo.findAll();
    }

    @Transactional(readOnly = true)
    public List<Ingredient> filterByType(Ingredient.Type type) {
        return ingredientRepo.findByType(type);
    }
}
