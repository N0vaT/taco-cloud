package com.nova.tacocloud.services;

import com.nova.tacocloud.dao.OrderRepository;
import com.nova.tacocloud.dao.OrderRepositoryJdbc;
import com.nova.tacocloud.domain.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(TacoOrder tacoOrder) {
        orderRepository.save(tacoOrder);
    }
}
