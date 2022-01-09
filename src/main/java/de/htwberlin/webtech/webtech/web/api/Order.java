package de.htwberlin.webtech.webtech.web.api;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public long id;
    public String surname;
    public String lastname;
    public String street;
    public int postcode;
    public String city;
    public String country;
    public List<Product> products;

    public Order(long id, String surname, String lastname, String street, int postcode, String city, String country, List<Product> products) {
        this.id = id;
        this.surname = surname;
        this.lastname = lastname;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.products = products;
    }

    public long getId() {
        return id;
    }

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
