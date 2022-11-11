package ru.senkin.spring.market.convertors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.senkin.spring.market.dto.OrderDto;
import ru.senkin.spring.market.dto.OrderItemDto;
import ru.senkin.spring.market.dto.ProductDto;
import ru.senkin.spring.market.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConvertor {
    public OrderDto entityToDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setOrderId(order.getId());
        orderDto.setTotalPrice(order.getTotalPrice());

        orderDto.setItems(order.getItems().stream().map(orderItem -> new OrderItemDto(
                orderItem.getId(),
                order.getId(),
                new ProductDto(orderItem.getProduct().getId(), orderItem.getProduct().getTitle(), orderItem.getProduct().getPrice()),
                orderItem.getPrice_per_product(),
                orderItem.getQuantity(),
                orderItem.getPrice()))
                .collect(Collectors.toList()));

        return orderDto;
    }

}
