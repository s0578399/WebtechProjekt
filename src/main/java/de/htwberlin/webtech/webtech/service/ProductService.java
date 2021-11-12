package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.web.api.Product;
import de.htwberlin.webtech.webtech.web.api.ProductCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream()
                .map(ProductEntity -> transformEntity(ProductEntity))
                .collect(Collectors.toList());
    }

    public Product create(ProductCreateRequest request) {
        var productEntity = new ProductEntity(request.getName(), request.getPrice());
        productEntity = productRepository.save(productEntity);
        return transformEntity(productEntity);

    }

    private Product transformEntity(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice()
        );
    }
}
