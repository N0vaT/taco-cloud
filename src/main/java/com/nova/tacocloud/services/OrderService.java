package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.OrderRepository;
import com.nova.tacocloud.domain.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void save(TacoOrder tacoOrder) {
        tacoOrder.setPlacedAt(LocalDateTime.now());
        orderRepository.save(tacoOrder);
    }
}
