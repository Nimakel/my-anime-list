package com.animelist.repository;

import com.animelist.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM User o LEFT JOIN o.orders WHERE o.id = :id")
    List<Order> getOrdersByUserId(Long id);
}
