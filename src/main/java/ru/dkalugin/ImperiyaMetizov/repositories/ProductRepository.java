package ru.dkalugin.ImperiyaMetizov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.entities.Subcategory;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select c.* from product as c where c.subcategory_id = :subcategory_id", nativeQuery = true)
    List<Product> findByCategoryId(@Param("subcategory_id") long subcategory_id);

}
