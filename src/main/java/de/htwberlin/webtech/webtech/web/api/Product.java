package de.htwberlin.webtech.webtech.web.api;

public class Product {
    public long id;
    public String productName;
    public String productDescription;
    public float costs;
    public String productUrl;

    public Product(long id, String productName, String productDescription, float costs, String productUrl) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.costs = costs;
        this.productUrl = productUrl;
    }

    public Product(){}

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

    public String getProductUrl() {return productUrl; }

    public void setProductUrl(String productUrl) { this.productUrl = productUrl; }
}
