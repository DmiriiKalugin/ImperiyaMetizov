package ru.dkalugin.ImperiyaMetizov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dkalugin.ImperiyaMetizov.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
