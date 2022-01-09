package de.htwberlin.webtech.webtech.web;
import de.htwberlin.webtech.webtech.service.OrderService;
import de.htwberlin.webtech.webtech.web.api.Order;
import de.htwberlin.webtech.webtech.web.api.OrderManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping(path = "/api/v1/order")
    public ResponseEntity<List<Order>> Orders() { return ResponseEntity.ok(orderService.findAll()); }

    @GetMapping(path = "/api/v1/order/{id}")
    public ResponseEntity<Order> OrdersById(@PathVariable Long id) {
        var order = orderService.findById(id);
        return order != null? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/order")
    public ResponseEntity<Void> createOrder(@RequestBody OrderManipulationRequest request) throws URISyntaxException {
        var order = orderService.create(request);
        URI uri = new URI("/api/v1/order/" + order.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderManipulationRequest request) {
        var order = orderService.update(id, request);
        return order != null? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        boolean successful = orderService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
