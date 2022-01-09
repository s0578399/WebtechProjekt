package de.htwberlin.webtech.webtech;

import de.htwberlin.webtech.webtech.persistence.OrderEntity;
import de.htwberlin.webtech.webtech.persistence.OrderRepository;
import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.service.OrderService;
import de.htwberlin.webtech.webtech.web.api.Order;
import de.htwberlin.webtech.webtech.web.api.OrderManipulationRequest;
import de.htwberlin.webtech.webtech.web.api.Product;
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
public class OrderServiceTest {

    @Autowired
    private OrderService service;

    @MockBean
    private OrderRepository repository;

    Product p1 = new Product(1L, "Kaktus", "keine Beschreibung", 25.00F, "keine URL");
    Product p2 = new Product(2L, "Pflanze", "keine Beschreibung", 10.00F, "keine URL");
    List<Product> pl1 = new ArrayList<>();


    @Test
    @DisplayName("should return all orders from repository")
    void findAllTest() {
        List<Order> ol = new ArrayList<>();
        pl1.add(p1); pl1.add(p2);

        Order o1 = new Order(1L, "Max", "Mustermann", "keine", 3483084, "Musterstadt",
                "Musterland", pl1);
        Order o2 = new Order(2L, "James", "Doe", "keine", 3483084, "Musterstadt",
                "Deutschland", pl1);

        ol.add(o1); ol.add(o2);
        ProductEntity p4 = new ProductEntity("Kaktus", "keine Beschreibung", 25.00F, "Keine URL");
        ProductEntity p5 = new ProductEntity("Blume", "keine Beschreibung", 10.00F, "Keine URL");
        List<ProductEntity> pel1 = new ArrayList<>(); pel1.add(p4); pel1.add(p5);
        List<OrderEntity> oel = new ArrayList<>();
        OrderEntity oe1 = new OrderEntity("Max", "Mustermann", "keine", 3483084, "Musterstadt",
                "Musterland", pel1);
        OrderEntity oe2 = new OrderEntity("James", "Doe", "keine", 3483084, "Musterstadt",
                "Musterland", pel1);
        oel.add(oe1); oel.add(oe2);

        doReturn(oel).when(repository).findAll();
        List<Order> actual = service.findAll();

        assertEquals(actual.get(0).getPostcode(), ol.get(0).getPostcode());

    }

    @Test
    @DisplayName("should find an order by its id")
    void findByIdTest() {
        ProductEntity p4 = new ProductEntity("Kaktus", "keine Beschreibung", 25.00F, "Keine URL");
        ProductEntity p5 = new ProductEntity("Blume", "keine Beschreibung", 10.00F, "Keine URL");
        List<ProductEntity> pel1 = new ArrayList<>(); pel1.add(p4); pel1.add(p5);
        var oe1 = new OrderEntity("Max", "Mustermann", "keine", 3483084, "Musterstadt",
                "Musterland", pel1);
        doReturn(Optional.of(oe1)).when(repository).findById(1L);

        Order actual = service.findById(1L);

        assertEquals("Max", actual.getSurname());
    }

    @Test
    @DisplayName("should update an order")
    void updateTest() {
        var t1 = new ProductEntity("Kaktus", "Keine Beschreibung", 25.00F, "Keine URL");
        var t2 = new ProductEntity("Blume", "Keine Beschreibung", 10.00F, "Keine URL");
        List<ProductEntity> pel = new ArrayList<>(); pel.add(t1); pel.add(t2);
        var o1 = new Order(1L, "Max", "Mustermann", "keine", 3483084, "Musterstadt",
                "Musterland", pl1);
        var o2 = new OrderEntity("James", "Doe", "keine", 3483084, "Musterstadt",
                "Musterland", pel);
        var omr = new OrderManipulationRequest("James", "Doe", "keine", 3483084, "Musterstadt",
                "Musterland", pel);

        doReturn(Optional.of(o2)).when(repository).findById(1L);
        doReturn(o2).when(repository).save(o2);

        var actual = service.update(1L, omr);

        assertEquals("James", actual.getSurname());
    }

    @Test
    @DisplayName("should delete an order by its id")
    void deleteByIdTest() {
        doReturn(true).when(repository).existsById(1L);
        var actual = service.deleteById(1L);
        assertEquals(true, actual);
    }
}
