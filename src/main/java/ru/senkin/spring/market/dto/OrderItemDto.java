package ru.senkin.spring.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.senkin.spring.market.entities.Order;
import ru.senkin.spring.market.entities.Product;

@Data
@AllArgsConstructor
public class OrderItemDto {
    private Long id;
    private Order order;
    private Product product;
    private int price_per_product;
    private int quantity;
    private int price;
}
