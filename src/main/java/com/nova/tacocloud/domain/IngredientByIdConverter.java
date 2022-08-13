package com.nova.tacocloud.domain;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",  new Ingredient("FLTO", "Мучная лепешка", Type.WRAP));
        ingredientMap.put("COTO",  new Ingredient("COTO", "Кукурузная лепешка", Type.WRAP));
        ingredientMap.put("GRBF",  new Ingredient("GRBF", "Говяжий фарш", Type.PROTEIN));
        ingredientMap.put("CARN",  new Ingredient("CARN", "Котлета", Type.PROTEIN));
        ingredientMap.put("TMTO",  new Ingredient("TMTO", "Салат", Type.VEGGIES));
        ingredientMap.put("CHED",  new Ingredient("CHED", "Чеддер", Type.CHEESE));
        ingredientMap.put("JACK",  new Ingredient("JACK", "Сыр Джек", Type.CHEESE));
        ingredientMap.put("SLSA",  new Ingredient("SLSA", "Сальса", Type.SAUCE));
        ingredientMap.put("SRCR",  new Ingredient("SRCR", "Сметана", Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}
