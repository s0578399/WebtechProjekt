package de.htwberlin.webtech.webtech.web.api;

public class ProductManipulationRequest {

    public String productName;
    public String productDescription;
    public float costs;

    public ProductManipulationRequest(String productName, String productDescription, float costs) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.costs = costs;
    }

    public ProductManipulationRequest(){};

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
