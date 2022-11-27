package ru.senkin.marker.api.dto;

import java.util.List;

public class OrderDto {
    private Long orderId;
    private List<OrderItemDto> items;
    private int totalPrice;

    public Long getOrderId() {
        return orderId;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
