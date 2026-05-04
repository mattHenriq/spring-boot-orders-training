package com.training.orders.dto;

import com.training.orders.enums.OrderType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrderRequest {

    @NotNull
    private OrderType type;

    private String symbol;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private Long customerId;

    public OrderType getType() { return type; }
    public void setType(OrderType type) { this.type = type; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
