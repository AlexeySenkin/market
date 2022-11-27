package ru.senkin.market.carts.convertors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.senkin.marker.api.dto.CartItemDto;
import ru.senkin.market.carts.model.CartItem;

@Component
public class CartItemConvertor {
    public CartItemDto entityToDto(CartItem cartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setPrice(cartItem.getPrice());
        cartItemDto.setPricePerProduct(cartItem.getPricePerProduct());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setProductTitle(cartItem.getProductTitle());
        cartItemDto.setProductId(cartItem.getProductId());
        return cartItemDto;
    }
}
