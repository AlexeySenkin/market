package ru.senkin.market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.marker.api.dto.ProductDto;
import ru.senkin.marker.api.dto.ResourceNotFoundException;
import ru.senkin.market.carts.integrations.ProductServiceIntegration;
import ru.senkin.market.carts.model.Cart;


import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);//.orElseThrow(() -> new ResourceNotFoundException("Не возможно добавить продукт в корзину. Продукт не найден. (id:" + productId + ")"));
        tempCart.add(product);
    }

    public void delete(Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);//.orElseThrow(() -> new ResourceNotFoundException("Не возможно удалиить продукт из корзины. Продукт не найден. (id:" + productId + ")"));
        tempCart.delete(product);
    }

    public void deleteAll() {
        tempCart.deleteAll();
    }
}
