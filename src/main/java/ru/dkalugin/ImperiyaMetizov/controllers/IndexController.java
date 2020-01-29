package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;

import java.util.List;

@Controller
public class IndexController {

    private ProductServices productService;

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(Model model){
        List<Product> allProduct = productService.getAllProducts();
        model.addAttribute("product", allProduct);
        return "index";
    }
}
