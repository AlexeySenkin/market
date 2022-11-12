package ru.senkin.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import ru.senkin.marker.api.dto.OrderDto;
import ru.senkin.market.core.convertors.OrderConvertor;
import ru.senkin.market.core.entities.User;
import ru.senkin.market.core.services.OrderService;
import ru.senkin.market.core.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;
    private final OrderConvertor orderConvertor;

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
        List<OrderDto> orderDtos;
        orderDtos = orderService.findByUser(user).stream().map(orderConvertor::entityToDto).collect(Collectors.toList());
        return orderDtos;
    }


}
