package ru.senkin.market.carts.controllers;


import ru.senkin.market.carts.convertors.CartConvertor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.senkin.marker.api.dto.CartDto;
import ru.senkin.market.carts.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConvertor cartConvertor;


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
    public CartDto getCurrentCart() {
        return cartConvertor.entityToDto(cartService.getCurrentCart());
    }

}
