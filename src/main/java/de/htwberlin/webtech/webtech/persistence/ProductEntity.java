package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;

@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "costs", nullable = false)
    private float costs;

    @Column(name = "product_url", nullable = false)
    private String productUrl;


    public ProductEntity(String productName, String productDescription, float costs, String productUrl) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.costs = costs;
        this.productUrl = productUrl;
    }

    protected ProductEntity() {}

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

    public String getProductUrl() { return productUrl; }

    public void setProductUrl(String productUrl) { this.productUrl = productUrl; }
}
