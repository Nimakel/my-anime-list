package com.animelist.service;

import com.animelist.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order add(Order order);

    List<Order> getOrdersByUserId(Long id);

    Order update(Long id, Order order);

    void delete(Long id);

    Optional<Order> findById(Long id);
}
