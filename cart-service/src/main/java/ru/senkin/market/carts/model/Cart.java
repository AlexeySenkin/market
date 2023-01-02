package ru.senkin.market.carts.model;


import lombok.Data;
import ru.senkin.marker.api.dto.ProductDto;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
public class Cart {
    private BigDecimal totalPrice;
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(ProductDto product) {
//        CartItem item = new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice());

        CartItem item = CartItem.newBuilder()
                .withProductId(product.getId())
                .withProductTitle(product.getTitle())
                .withQuantity(1)
                .withPricePerProduct(product.getPrice())
                .withPrice(product.getPrice())
                .build();

        boolean productFindInCart = false;
        if (items.isEmpty()) {
            items.add(item);
        } else {
            for (CartItem i : items) {
                if (Objects.equals(i.getProductId(), product.getId())) {
                    i.setQuantity(i.getQuantity() + 1);
                    i.setPrice(i.getPrice().add(i.getPricePerProduct()));
                    productFindInCart = true;
                    break;
                }
            }
            if (!productFindInCart) {
                items.add(item);
            }
        }
        recalculate();
    }

    public void delete(ProductDto product) {
        items.remove(items.removeIf(item -> item.getProductId().equals(product.getId())));
        recalculate();
    }

    public void deleteAll() {
        items.clear();
        recalculate();
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        for (CartItem item : items) {
            totalPrice = totalPrice.add(item.getPrice());
        }

    }


}
