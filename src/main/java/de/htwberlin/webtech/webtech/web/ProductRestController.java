package de.htwberlin.webtech.webtech.web;

import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.service.ProductService;
import de.htwberlin.webtech.webtech.web.api.Product;
import de.htwberlin.webtech.webtech.web.api.ProductCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductRestController {


    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/api/v1/products")
    public ResponseEntity<List<Product>>fetchProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping(path = "/api/v1/products")
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) throws URISyntaxException {
        var product = productService.create(request);
        URI uri = new URI("/api/v1/products" + product.getId());
        return ResponseEntity.created(uri).build();
    }
}
