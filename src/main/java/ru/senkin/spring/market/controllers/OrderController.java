package ru.senkin.spring.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ru.senkin.spring.market.dto.Cart;
import ru.senkin.spring.market.dto.OrderDto;
import ru.senkin.spring.market.dto.ProductDto;
import ru.senkin.spring.market.entities.User;
import ru.senkin.spring.market.services.OrderService;
import ru.senkin.spring.market.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new RuntimeException());
        //TODO: fix
        orderService.createOrder(user);
    }

    @GetMapping
    public List<OrderDto> getOrders(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new RuntimeException());
        List<OrderDto> orderDtos = orderService.findByUser(user).stream().map(order -> new OrderDto(order.getId(),order.getItems(),order.getTotalPrice())).collect(Collectors.toList());
        return orderDtos;
    }

}
