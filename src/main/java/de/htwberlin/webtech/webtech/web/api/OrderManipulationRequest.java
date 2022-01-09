package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;

import java.util.List;

public class OrderManipulationRequest {

    public String surname;
    public String lastname;
    public String street;
    public int postcode;
    public String city;
    public String country;
    public List<ProductEntity> products;

    public OrderManipulationRequest(String surname, String lastname, String street, int postcode, String city, String country, List<ProductEntity> products) {
        this.surname = surname;
        this.lastname = lastname;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.products = products;
    }

    public OrderManipulationRequest(){};

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
