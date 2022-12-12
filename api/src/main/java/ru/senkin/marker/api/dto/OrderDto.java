package ru.senkin.marker.api.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private Long orderId;
    private List<OrderItemDto> items;
    private BigDecimal totalPrice;

    public Long getOrderId() {
        return orderId;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderDto() {
    }

    public OrderDto(Long orderId, List<OrderItemDto> items, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
    }
}
