package ru.senkin.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.spring.market.dto.Cart;
import ru.senkin.spring.market.entities.Product;
import ru.senkin.spring.market.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не возможно добавить продукт в корзину. Продукт не найден. (id:" + productId + ")"));
        tempCart.add(product);
    }

    public void delete(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не возможно удалиить продукт из корзины. Продукт не найден. (id:" + productId + ")"));
        tempCart.delete(product);
    }

    public void deleteAll() {
        tempCart.deleteAll();
    }
}
