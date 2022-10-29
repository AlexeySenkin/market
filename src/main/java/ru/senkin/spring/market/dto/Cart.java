package ru.senkin.spring.market.dto;


import lombok.Data;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import ru.senkin.spring.market.entities.Product;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Data
public class Cart {
    private int totalPrice;
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        CartItem item = new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice());
        boolean productFindInCart = false;
        if (items.isEmpty()) {
            items.add(item);
        } else {
            for (CartItem i : items) {
                if (Objects.equals(i.getProductId(), product.getId())) {
                    i.setQuantity(i.getQuantity() + 1);
                    i.setPrice(i.getPrice() + i.getPricePerProduct());
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

    public void delete(Product product) {
        items.remove(items.removeIf(item -> item.getProductId().equals(product.getId())));
        recalculate();
    }

    public void deleteAll() {
        items.clear();
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }

    }


}
