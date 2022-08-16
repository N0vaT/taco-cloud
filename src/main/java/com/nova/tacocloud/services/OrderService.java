package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.IngredientRepository;
import com.nova.tacocloud.dao.OrderRepository;
import com.nova.tacocloud.dao.TacoRepository;
import com.nova.tacocloud.domain.Ingredient;
import com.nova.tacocloud.domain.Taco;
import com.nova.tacocloud.domain.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private TacoRepository tacoRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public void save(TacoOrder tacoOrder, List<Taco> tacos) {
        tacoOrder.setPlacedAt(LocalDateTime.now());

        orderRepository.saveAndFlush(tacoOrder);

//        TacoOrder TO = new TacoOrder();
//        TO.setDeliveryName(tacoOrder.getDeliveryName());
//        TO.setDeliveryStreet(tacoOrder.getDeliveryStreet());
//        TO.setDeliveryCity(tacoOrder.getDeliveryCity());
//        TO.setDeliveryState(tacoOrder.getDeliveryState());
//        TO.setDeliveryZip(tacoOrder.getDeliveryZip());
//        TO.setCcNumber(tacoOrder.getCcNumber());
//        TO.setCcExpiration(tacoOrder.getCcExpiration());
//        TO.setCcCVV(tacoOrder.getCcCVV());
//        TO.setPlacedAt(LocalDateTime.now());
//        List<Taco> TF = tacoOrder.getTacos();
//        List<Taco> TSF = new ArrayList<>();
//        TF.forEach(t->{
//            List<Ingredient> listI = new ArrayList<>();
//            t.getIngredients().forEach(i-> {
//                Ingredient I = new Ingredient(i.getId(),i.getName(),i.getType());
//                listI.add(I);
//            });
//            Taco T = new Taco();
//            T.setName(t.getName());
//            T.setIngredients(listI);
//            T.setCreatedAt(LocalDateTime.now());
//            T.setTacoOrder(TO);
//            TSF.add(T);
//        });
//        TO.setTacos(TSF);
//        orderRepository.save(TO);
    }
}
