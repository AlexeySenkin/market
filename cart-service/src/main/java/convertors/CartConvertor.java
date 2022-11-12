package convertors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.senkin.marker.api.dto.CartDto;
import ru.senkin.market.carts.model.Cart;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConvertor {
    private final CartItemConvertor cartItemConvertor;

    public CartDto entityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setTotalPrice(cart.getTotalPrice());
        cartDto.setItems(cart.getItems().stream().map(cartItemConvertor::entityToDto).collect(Collectors.toList()));
        return cartDto;
    }

}
