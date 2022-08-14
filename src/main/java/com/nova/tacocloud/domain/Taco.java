package com.nova.tacocloud.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Taco {

    private Long id;
    @NotNull
    @Size(min = 3, max=20, message = "Поле должно содержать минимум 3 и максимум 20 символов")
    private String name;
    @NotNull
    @Size(min = 1, message = "Выберети хотя бы 1 ингридиет")
    private List<Ingredient> ingredients;
    private LocalDateTime createdAt= LocalDateTime.now();

}
