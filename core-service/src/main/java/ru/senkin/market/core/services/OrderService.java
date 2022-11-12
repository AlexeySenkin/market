package ru.senkin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.market.core.entities.Order;
import ru.senkin.market.core.entities.User;
import ru.senkin.market.core.repositories.OrderRepositories;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
      private final OrderRepositories orderRepositories;
//    private final ProductService productService;
//    private final OrderService orderService;


    public void createOrder(User user) {

//        cart.getItems().stream().map(cartItem -> {
//            new OrderItem(null,
//
//                    productService.findById(cartItem.getProductId()))
//        });

    }


    public Optional<Order> findByUser(User user) {
        return orderRepositories.findByUser(user);
    }
}
