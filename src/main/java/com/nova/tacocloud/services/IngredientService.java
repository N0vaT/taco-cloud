package com.nova.tacocloud.services;

import com.nova.tacocloud.domain.Ingredient;
import com.nova.tacocloud.domain.Type;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    public List<Ingredient> findAll(){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Мучная лепешка", Type.WRAP),
                new Ingredient("COTO", "Кукурузная лепешка", Type.WRAP),
                new Ingredient("GRBF", "Говяжий фарш", Type.PROTEIN),
                new Ingredient("CARN", "Котлета", Type.PROTEIN),
                new Ingredient("TMTO", "Салат", Type.VEGGIES),
                new Ingredient("CHED", "Чеддер", Type.CHEESE),
                new Ingredient("JACK", "Сыр Джек", Type.CHEESE),
                new Ingredient("SLSA", "Сальса", Type.SAUCE),
                new Ingredient("SRCR", "Сметана", Type.SAUCE)
        );
        return ingredients;
    }

    public List<Ingredient> filterByType(Type type) {
        return findAll().stream().filter(x -> x.getType().toString().equals(type.toString())).collect(Collectors.toList());
    }
}
