package de.htwberlin.webtech.webtech.web.api;

public class Product {
    public long id;
    public String productName;
    public String productDescription;
    public float costs;

    public Product(long id, String productName, String productDescription, float costs) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.costs = costs;
    }

    public long getId() {
        return id;
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

    public float getCosts() {
        return costs;
    }

    public void setCosts(float costs) {
        this.costs = costs;
    }
}