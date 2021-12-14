package de.htwberlin.webtech.webtech.repository;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface BucketRepository extends JpaRepository<CategoryEntity, Long> {
        //List<BucketEntity> findAllByCategoryName(String categoryName);

}
