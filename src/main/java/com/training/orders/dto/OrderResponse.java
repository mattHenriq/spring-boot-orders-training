package com.training.orders.dto;

import com.training.orders.entity.Order;
import com.training.orders.enums.OrderStatus;
import com.training.orders.enums.OrderType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponse {

    private Long id;
    private OrderType type;
    private String symbol;
    private BigDecimal price;
    private Integer quantity;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public static OrderResponse fromEntity(Order order) {
        OrderResponse response = new OrderResponse();
        response.id = order.getId();
        response.type = order.getType();
        response.symbol = order.getSymbol();
        response.price = order.getPrice();
        response.quantity = order.getQuantity();
        response.status = order.getStatus();
        response.createdAt = order.getCreatedAt();
        return response;
    }

    private Long customerId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public OrderType getType() { return type; }
    public void setType(OrderType type) { this.type = type; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
