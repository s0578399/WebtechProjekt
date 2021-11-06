package de.htwberlin.webtech.webtech.web;

import de.htwberlin.webtech.webtech.web.api.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductRestController {

    private List<Product> products;

    public ProductRestController() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Kaktus", 5.00));
        products.add(new Product(2, "Apfelbaum", 30.00));
        products.add(new Product(3, "Kirschbaum", 15.00));
    }

    @GetMapping(path = "/api/v1/products")
    public ResponseEntity<List<Product>>fetchProducts() {
        return ResponseEntity.ok(products);
    }

}
