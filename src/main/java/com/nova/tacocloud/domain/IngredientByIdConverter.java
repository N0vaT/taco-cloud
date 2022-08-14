package com.nova.tacocloud.domain;

import com.nova.tacocloud.dao.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",  new Ingredient("FLTO", "Мучная лепешка", Ingredient.Type.WRAP));
        ingredientMap.put("COTO",  new Ingredient("COTO", "Кукурузная лепешка", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF",  new Ingredient("GRBF", "Говяжий фарш", Ingredient.Type.PROTEIN));
        ingredientMap.put("CARN",  new Ingredient("CARN", "Котлета", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO",  new Ingredient("TMTO", "Салат", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",  new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK",  new Ingredient("JACK", "Сыр Джек", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA",  new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR",  new Ingredient("SRCR", "Сметана", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }

}
