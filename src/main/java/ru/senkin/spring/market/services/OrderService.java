package ru.senkin.spring.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.spring.market.dto.Cart;
import ru.senkin.spring.market.dto.OrderDto;
import ru.senkin.spring.market.entities.*;
import ru.senkin.spring.market.repositories.OrderRepositories;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
      private final OrderRepositories orderRepositories;
//    private final ProductService productService;
//    private final OrderService orderService;


    public void createOrder(User user) {

        Cart cart = new Cart();
        Order order = new Order();

//        cart.getItems().stream().map(cartItem -> {
//            new OrderItem(null,
//
//                    productService.findById(cartItem.getProductId()))
//        });

    }


    public List<Order> findByUser(User user) {
        //return orderRepositories.findByUser(user);
        return orderRepositories.findAll();
    }
}
