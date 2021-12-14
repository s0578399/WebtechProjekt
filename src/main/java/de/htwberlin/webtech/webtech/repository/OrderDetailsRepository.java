package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
