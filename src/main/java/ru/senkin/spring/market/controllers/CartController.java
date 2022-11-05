package ru.senkin.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.senkin.spring.market.dto.Cart;
import ru.senkin.spring.market.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.delete(id);
    }

    @GetMapping("/delete/all")
    public void deleteAllProductFromCart() {
        cartService.deleteAll();
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

}
