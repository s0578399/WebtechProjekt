package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

    List<UserEntity> findAllByFirstName(String firstName);

}
