package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.CategoryEntity;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

public class Product {
    public long id;
    public String productName;
    public String productDescription;
    public BigDecimal productPrice;

    public Product(long id, String productName, String productDescription, BigDecimal productPrice, List<CategoryEntity> categories) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
