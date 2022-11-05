package ru.senkin.spring.market.dto;

import lombok.Data;
import ru.senkin.spring.market.entities.OrderItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class OrderDto {
    private Long orderId;
    private List<OrderItem> items;
    private int totalPrice;

    public OrderDto() {
        this.items = new ArrayList<>();
    }

    public OrderDto(Long orderId, List<OrderItem> items, int totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

}
