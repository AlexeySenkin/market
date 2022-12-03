package ru.senkin.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import ru.senkin.marker.api.dto.CartDto;
import ru.senkin.marker.api.dto.ProductDto;


@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

//    public Optional<ProductDto> getProductById(Long id) {
//        return Optional.ofNullable(restTemplate.getForObject("http://localhost:8189/market/api/v1/products/" + id, ProductDto.class));
//    }

    public CartDto getCurrentCart() {
        return cartServiceWebClient.get()
                .uri("/api/v1/cart/")
                .retrieve()
//                .onStatus(
//                        httpStatus -> httpStatus.value() == HttpStatus.NOT_FOUND.value(),
//                        clientResponse -> Mono.error(new ResourceNotFoundException("id товара не найден в продуктовом МС "))
//                )
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clear() {
        cartServiceWebClient.get()
                .uri("/api/v1/clear/")
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }
}
