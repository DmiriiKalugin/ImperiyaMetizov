package ru.dkalugin.ImperiyaMetizov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.CategoryServices;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

import javax.validation.Valid;
import java.util.List;

@Controller
public class IndexController {
    private CategoryServices categoryServices;
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }



    @GetMapping("/")
    public String index(FormFooter formFooter, Model model) {
        List<Category> allCategory = categoryServices.getAllCategory();
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("category", allCategory);
        model.addAttribute("greeting",formFooter);
        return "index";
    }


}
