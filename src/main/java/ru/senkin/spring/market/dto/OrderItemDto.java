package ru.senkin.spring.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private Long orderId;
    private ProductDto productDto;
    private int price_per_product;
    private int quantity;
    private int price;
}
