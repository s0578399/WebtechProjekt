package de.htwberlin.webtech.webtech.service;

import de.htwberlin.webtech.webtech.persistence.OrderEntity;
import de.htwberlin.webtech.webtech.persistence.OrderRepository;
import de.htwberlin.webtech.webtech.persistence.ProductEntity;
import de.htwberlin.webtech.webtech.web.api.Order;
import de.htwberlin.webtech.webtech.web.api.OrderManipulationRequest;
import de.htwberlin.webtech.webtech.web.api.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    public List<Order> findAll(){
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Order findById(long id) {
        var orderEntity = orderRepository.findById(id);
        return orderEntity.isPresent() ? transformEntity(orderEntity.get()) : null;
    }

    public Order create(OrderManipulationRequest orderManipulationRequest) {
        var orderEntity = new OrderEntity(orderManipulationRequest.getSurname(), orderManipulationRequest.getLastname(), orderManipulationRequest.getStreet(),
                orderManipulationRequest.getPostcode(), orderManipulationRequest.getCity(), orderManipulationRequest.getCountry(), orderManipulationRequest.getProducts());
        orderEntity = orderRepository.save(orderEntity);
        return transformEntity(orderEntity);
    }

    public Order update(Long id, OrderManipulationRequest request) {
        var orderEntityOptional = orderRepository.findById(id);
        if (orderEntityOptional.isEmpty()) {
            return null;
        }
        var orderEntity = orderEntityOptional.get();
        orderEntity.setSurname(request.getSurname());
        orderEntity.setLastname(request.getLastname());
        orderEntity.setStreet(request.getStreet());
        orderEntity.setPostcode(request.getPostcode());
        orderEntity.setCity(request.getCity());
        orderEntity.setCountry(request.getCountry());
        orderEntity.setProducts(request.getProducts());
        orderEntity = orderRepository.save(orderEntity);
        return transformEntity(orderEntity);
    }

    public boolean deleteById(Long id) {
        if(!orderRepository.existsById(id)) {
            return false;
        }
        orderRepository.deleteById(id);
        return true;
    }

    private Order transformEntity(OrderEntity orderEntity) {
        return new Order(
                orderEntity.getId(),
                orderEntity.getSurname(),
                orderEntity.getLastname(),
                orderEntity.getStreet(),
                orderEntity.getPostcode(),
                orderEntity.getCity(),
                orderEntity.getCountry(),
                transformEntityList(orderEntity.getProducts())
        );
    }

    private List<Product> transformEntityList(List<ProductEntity> products) {
        List<Product> transformedProducts = new ArrayList<Product>();
        for(ProductEntity p : products) {
            transformedProducts.add(new Product(p.getId(), p.getProductName(), p.getProductDescription(), p.getCosts(), p.getProductUrl()));
        }
        return transformedProducts;
    }

    private List<ProductEntity> transformEntityListReverse(List<Product> products) {
        List<ProductEntity> transformedProducts = new ArrayList<ProductEntity>();
        for(Product p : products) {
            transformedProducts.add(new ProductEntity(p.getProductName(), p.getProductDescription(), p.getCosts(), p.getProductUrl()));
        }
        return transformedProducts;
    }



}
