package ru.senkin.spring.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

}
