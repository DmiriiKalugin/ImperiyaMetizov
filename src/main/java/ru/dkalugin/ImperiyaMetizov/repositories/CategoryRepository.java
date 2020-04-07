package ru.dkalugin.ImperiyaMetizov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.entities.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
