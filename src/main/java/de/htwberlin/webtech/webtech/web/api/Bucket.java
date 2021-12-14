package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;

import java.util.List;

public class Bucket {
    private long id;
    private UserEntity user;
    private List<ProductEntity> products;

    public Bucket(long id, UserEntity user, List<ProductEntity> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
