package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.entities.Subcategory;
import ru.dkalugin.ImperiyaMetizov.repositories.CategoryRepository;
import ru.dkalugin.ImperiyaMetizov.repositories.SubcategoryRepository;

import java.util.List;

@Service
public class SubcategoryServices {
    private SubcategoryRepository subcategoryRepository;
    private Subcategory subcategory = new Subcategory();

    @Autowired
    public void setSubcategoryRepository(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public List<Subcategory> getSubcategory(){
        return subcategoryRepository.findAll();
    }

    public List<Subcategory> findByCategoryId(long category_id){
        return subcategoryRepository.findByCategoryId(category_id);
    }

    public Subcategory getCategory_id(long id){
        return subcategoryRepository.getOne(id);
   }

    public void deleteById(Long id){
        subcategoryRepository.deleteById(id);
    }
}
