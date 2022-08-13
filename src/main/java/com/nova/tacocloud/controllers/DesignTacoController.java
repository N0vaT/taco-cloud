package com.nova.tacocloud.controllers;

import com.nova.tacocloud.domain.Taco;
import com.nova.tacocloud.domain.TacoOrder;
import com.nova.tacocloud.domain.Type;
import com.nova.tacocloud.services.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @Autowired
    private IngredientService ingredientService;

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        for(Type type: Type.values()){
            model.addAttribute(type.toString().toLowerCase(), ingredientService.filterByType(type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder){
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
}
