package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import com.example.techtask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order findOrder() {
        return orderRepository.findNewestMoreThanOneItem();
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findFromActiveUsers();
    }
}
