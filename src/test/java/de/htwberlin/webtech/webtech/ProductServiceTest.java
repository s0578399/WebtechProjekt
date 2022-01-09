package de.htwberlin.webtech.webtech;

import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.persistence.ProductRepository;
import de.htwberlin.webtech.webtech.service.ProductService;
import de.htwberlin.webtech.webtech.web.api.Product;
import de.htwberlin.webtech.webtech.web.api.ProductManipulationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepository repository;

    @Test
    @DisplayName("should return all products from repository")
    void findAllTest() {
        List<Product> t1 = new ArrayList<>();
        Product p1 = new Product(1, "Kaktus", "Keine Beschreibung", 25.00F, "Keine URL");
        Product p2 = new Product(1, "Blume", "Keine Beschreibung", 10.00F, "Keine URL");
        Product p3 = new Product(1, "Apfelbaum", "Keine Beschreibung", 50.00F, "Keine URL");
        t1.add(p1); t1.add(p2); t1.add(p3);
        List<ProductEntity> t2 = new ArrayList<>();
        ProductEntity p4 = new ProductEntity("Kaktus", "keine Beschreibung", 25.00F, "Keine URL");
        ProductEntity p5 = new ProductEntity("Blume", "keine Beschreibung", 10.00F, "Keine URL");
        ProductEntity p6 = new ProductEntity("Apfelbaum", "keine Beschreibung", 50.00F, "Keine URL");
        t2.add(p4); t2.add(p5); t2.add(p6);

        doReturn(t2).when(repository).findAll();
        List<Product> actual = service.findAll();

        assertEquals(actual.get(0).getProductName(), t1.get(0).getProductName());
        assertEquals(actual.get(1).getProductName(), t1.get(1).getProductName());
        assertEquals(actual.get(2).getProductName(), t1.get(2).getProductName());
    }

    @Test
    @DisplayName("should find a product by its id")
    void findByIdTest() {
        var t1 = new ProductEntity("Kaktus", "Keine Beschreibung", 25.00F, "Keine URL");
        var t2 = new ProductEntity("Blume", "Keine Beschreibung", 10.00F, "Keine URL");

        doReturn(Optional.of(t1)).when(repository).findById(2L);
        doReturn(Optional.of(t1)).when(repository).findById(3L);

        Product actual = service.findById(2L);

        assertEquals(actual.getCosts(), 25.00F);
    }


    @Test
    @DisplayName("should update a product")
    void updateTest() {
        var p1 = new Product(1, "Kaktus", "keine Beschreibung", 25.00F, "Keine URL");
        var p3 = new ProductManipulationRequest("Kaktus", "keine Beschreibung", 25.00F, "Keine URL");
        var p2 = new ProductEntity("Kaktus", "keine Beschreibung", 10.00F, "Keine URL");


        doReturn(Optional.of(p2)).when(repository).findById(2L);
        doReturn(p2).when(repository).save(p2);

        var actual = service.update(2L, p3);

        assertEquals(actual.getProductName(), "Kaktus");

    }

    @Test
    @DisplayName("should delete a product by its id")
    void deleteByIdTest() {
        doReturn(true).when(repository).existsById(1L);
        var actual = service.deleteById(1L);
        assertEquals(true, service.deleteById(1L));
    }
}
