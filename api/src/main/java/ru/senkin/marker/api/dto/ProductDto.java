package ru.senkin.marker.api.dto;


public class ProductDto {
    private Long id;
    private String title;
    private int price;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductDto() {
    }

    public ProductDto(Long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
