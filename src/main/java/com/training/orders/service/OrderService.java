package com.training.orders.service;

import com.training.orders.dto.OrderRequest;
import com.training.orders.dto.OrderResponse;
import com.training.orders.entity.Order;
import com.training.orders.enums.OrderStatus;
import com.training.orders.repository.OrderRepository;
import com.training.orders.exception.OrderNotFoundException;


import java.time.LocalDateTime;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;



@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

        public OrderResponse createOrder(OrderRequest request) {
            if (request.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Price must be positive");
            }
            
            Order order = new Order();
            order.setType(request.getType());
            order.setSymbol(request.getSymbol());
            order.setPrice(request.getPrice());
            order.setQuantity(request.getQuantity());
            order.setStatus(OrderStatus.PENDING);
            order.setCustomerId(request.getCustomerId());
            order.setCreatedAt(LocalDateTime.now());

            Order saveOrder = repository.save(order);

            return toResponse(saveOrder);
        }

private OrderResponse toResponse(Order order) {
            OrderResponse response = new OrderResponse();
            response.setId(order.getId());
            response.setType(order.getType());
            response.setSymbol(order.getSymbol());
            response.setPrice(order.getPrice());
            response.setQuantity(order.getQuantity());
            response.setStatus(order.getStatus());
            response.setCreatedAt(order.getCreatedAt());
            response.setCustomerId(order.getCustomerId());

            return response;

        }

        public OrderResponse getOrderById(long id){
            Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

            return toResponse(order);    
        }




    // EXERCÍCIO: implemente cancelOrder(Long id)
    // Regras:
    //   - ordem que não existe lança exceção
    //   - ordem já CANCELLED lança exceção
    //   - ordem EXECUTED não pode ser cancelada
    //   - apenas PENDING pode ser cancelada
}
