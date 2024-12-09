package com.diallo.exo1.service;


import com.diallo.exo1.entity.Order;
import com.diallo.exo1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).get();
    }
}
