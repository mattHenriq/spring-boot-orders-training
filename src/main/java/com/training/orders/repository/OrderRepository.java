package com.training.orders.repository;

import com.training.orders.entity.Order;
import com.training.orders.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);

    // EXERCÍCIO: adicione um método que busca ordens por status
    // EXERCÍCIO: adicione um método que busca por customerId E status
}
