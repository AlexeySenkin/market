package ru.senkin.spring.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.senkin.spring.market.entities.OrderItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private List<OrderItemDto> items;
    private int totalPrice;
//
//    public OrderDto() {
//        this.items = new ArrayList<>();
//    }


    public List<OrderItemDto> getItems() {
        return Collections.unmodifiableList(items);
    }

}
