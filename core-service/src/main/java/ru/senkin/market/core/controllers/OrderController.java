package ru.senkin.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import ru.senkin.marker.api.dto.OrderDto;
import ru.senkin.market.core.convertors.OrderConvertor;
import ru.senkin.market.core.services.OrderService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderConvertor orderConvertor;

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestHeader String username) {
//        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new RuntimeException());
        //TODO: fix
        orderService.createOrder(username);
    }

    @GetMapping
    public List<OrderDto> getOrders(String username) {
//        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new RuntimeException());
        List<OrderDto> orderDtos;
        orderDtos = orderService.findByUser(username).stream().map(orderConvertor::entityToDto).collect(Collectors.toList());
        return orderDtos;
    }


}
