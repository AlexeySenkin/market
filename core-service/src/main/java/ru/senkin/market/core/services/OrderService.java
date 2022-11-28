package ru.senkin.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.senkin.marker.api.dto.CartDto;
import ru.senkin.market.core.entities.Order;
import ru.senkin.market.core.entities.OrderItem;
import ru.senkin.market.core.integrations.CartServiceIntegration;
import ru.senkin.market.core.repositories.OrderRepositories;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepositories orderRepositories;
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;


    public void createOrder(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
        Order order = new Order();
        order.setUsername(username);
        order.setTotalPrice(cartDto.getTotalPrice());
//        order.setItems(cartDto.getItems().stream().map(
//                cartItem -> new OrderItem(
//                        productService.findById(cartItem.getProductId()).get(),
//                        order,
//                        cartItem.getPricePerProduct(),
//                        cartItem.getQuantity(),
//                        cartItem.getPrice()
//                )
//        ).collect(Collectors.toList()));
        orderRepositories.save(order);
        cartServiceIntegration.clear();
    }


    public Optional<Order> findByUser(String username) {
        return orderRepositories.findByUsername(username);
    }
}
