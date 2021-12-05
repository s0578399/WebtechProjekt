package de.htwberlin.webtech.webtech.web.api;

import java.math.BigDecimal;

public class ProductManipulationRequest {

    public String productName;
    public String productDescription;
    public BigDecimal productPrice;

    public ProductManipulationRequest(String productName, String productDescription, BigDecimal productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
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
