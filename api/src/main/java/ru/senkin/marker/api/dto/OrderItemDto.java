package ru.senkin.marker.api.dto;

import java.math.BigDecimal;

public class OrderItemDto {
    private Long id;
    private Long orderId;
    private ProductDto productDto;
    private BigDecimal price_per_product;
    private int quantity;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public BigDecimal getPrice_per_product() {
        return price_per_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public void setPrice_per_product(BigDecimal price_per_product) {
        this.price_per_product = price_per_product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderItemDto(Long id, Long orderId, ProductDto productDto, BigDecimal price_per_product, int quantity, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.productDto = productDto;
        this.price_per_product = price_per_product;
        this.quantity = quantity;
        this.price = price;
    }
}
