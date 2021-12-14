package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.OrderEntity;
import de.htwberlin.webtech.webtech.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllById(Long id);

}
