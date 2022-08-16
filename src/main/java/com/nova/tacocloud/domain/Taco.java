package com.nova.tacocloud.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Size(min = 3, max=20, message = "Поле должно содержать минимум 3 и максимум 20 символов")
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(min = 1, message = "Выберети хотя бы 1 ингридиет")
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "Taco_Ingredient", joinColumns = @JoinColumn(name = "taco_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients = new ArrayList<>();
    @Column(name = "created_at")
    private LocalDateTime createdAt=LocalDateTime.now();

//    @ManyToOne()
//    @JoinColumn(name = "taco_order_id")
//    private TacoOrder tacoOrder;

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
