package ru.dkalugin.ImperiyaMetizov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.dkalugin.ImperiyaMetizov.entities.Subcategory;

import java.util.List;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    @Query(value = "select c.* from subcategory as c where c.category_id = :category_id", nativeQuery = true)
    List<Subcategory> findByCategoryId(@Param("category_id") long category_id);
}
