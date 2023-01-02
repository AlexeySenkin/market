package ru.senkin.market.carts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;

    public static Builder newBuilder() {
        return new Builder();
    }


    public Long getProductId() {
        return productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPricePerProduct() {
        return pricePerProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPricePerProduct(BigDecimal pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private CartItem(Builder builder) {
        setProductId(builder.productId);
        setProductTitle(builder.productTitle);
        setQuantity(builder.quantity);
        setPricePerProduct(builder.pricePerProduct);
        setPrice(builder.price);
    }

    public static Builder newBuilder(CartItem copy) {
        Builder builder = new Builder();
        builder.productId = copy.getProductId();
        builder.productTitle = copy.getProductTitle();
        builder.quantity = copy.getQuantity();
        builder.pricePerProduct = copy.getPricePerProduct();
        builder.price = copy.getPrice();
        return builder;
    }

    public static final class Builder {
        private Long productId;
        private String productTitle;
        private int quantity;
        private BigDecimal pricePerProduct;
        private BigDecimal price;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withProductId(Long val) {
            productId = val;
            return this;
        }

        public Builder withProductTitle(String val) {
            productTitle = val;
            return this;
        }

        public Builder withQuantity(int val) {
            quantity = val;
            return this;
        }

        public Builder withPricePerProduct(BigDecimal val) {
            pricePerProduct = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
