package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.CategoryServices;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;
import ru.dkalugin.ImperiyaMetizov.services.SubcategoryServices;

import java.util.List;

@Controller
public class CartController {
    private ProductServices productService;
    private CategoryServices categoryServices;
    private SubcategoryServices subcategoryServices;

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }

    long id = 1;

    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("greeting", new FormFooter());
        return "cart";
    }

}
