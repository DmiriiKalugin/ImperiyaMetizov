package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.repositories.CategoryRepository;
import ru.dkalugin.ImperiyaMetizov.repositories.ProductRepository;

import java.util.List;

@Service
public class CategoryServices {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }


    public Category getCategoryId(long id){
        return categoryRepository.findById(id).get();
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
