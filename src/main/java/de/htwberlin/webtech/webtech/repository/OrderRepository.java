package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
