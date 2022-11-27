package ru.senkin.marker.api.dto;

public class OrderItemDto {
    private Long id;
    private Long orderId;
    private ProductDto productDto;
    private int price_per_product;
    private int quantity;
    private int price;

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public int getPrice_per_product() {
        return price_per_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
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

    public void setPrice_per_product(int price_per_product) {
        this.price_per_product = price_per_product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderItemDto(Long id, Long orderId, ProductDto productDto, int price_per_product, int quantity, int price) {
        this.id = id;
        this.orderId = orderId;
        this.productDto = productDto;
        this.price_per_product = price_per_product;
        this.quantity = quantity;
        this.price = price;
    }
}
