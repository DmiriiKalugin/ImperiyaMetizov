package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServices {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllBySubcategoryId(long subcategory_id){
        return productRepository.findByCategoryId(subcategory_id);
    }


    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
