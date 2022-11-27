package ru.senkin.marker.api.dto;


import java.util.List;



public class CartDto {
    private int totalPrice;
    private List<CartItemDto> items;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }
}
