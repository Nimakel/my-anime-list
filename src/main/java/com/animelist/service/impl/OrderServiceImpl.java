package com.animelist.service.impl;

import com.animelist.model.Order;
import com.animelist.repository.OrderRepository;
import com.animelist.service.OrderService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long id) {
        return orderRepository.getOrdersByUserId(id);
    }

    @Override
    public Order update(Long id, Order order) {
        Order reference = orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get Order from DB for update by ID: " + id));
        reference.setAnime(order.getAnime());
        reference.setMark(order.getMark());
        reference.setList(order.getList());
        reference.setChangesDate(LocalDateTime.now());
        return reference;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
