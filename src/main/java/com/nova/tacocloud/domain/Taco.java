package com.nova.tacocloud.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 3, max=20, message = "Поле должно содержать минимум 3 и максимум 20 символов")
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(min = 1, message = "Выберети хотя бы 1 ингридиет")
    @ManyToMany()
    private List<Ingredient> ingredients;
    @Column(name = "created_at")
    private LocalDateTime createdAt=LocalDateTime.now();

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
