package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.CategoryServices;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;
import ru.dkalugin.ImperiyaMetizov.services.SubcategoryServices;

import java.util.List;

@Controller
public class CatalogController {
    private ProductServices productService;
    private CategoryServices categoryServices;
    private SubcategoryServices subcategoryServices;

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @Autowired
    public void setSubcategoryServices(SubcategoryServices subcategoryServices) {
        this.subcategoryServices = subcategoryServices;
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        List<Category> allCategory = categoryServices.getAllCategory();

        model.addAttribute("category", allCategory);
        model.addAttribute("greeting", new FormFooter());
        return "catalog";
    }

    @GetMapping("/showSubcategory/{id}")
    public String showSubcategory(Model model, @PathVariable("id") long id){
        model.addAttribute("subcategory", subcategoryServices.findByCategoryId(id));
        model.addAttribute("greeting", new FormFooter());
        return "showSubcategory";
    }
}
