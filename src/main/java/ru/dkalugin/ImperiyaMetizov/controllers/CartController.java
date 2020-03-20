package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.CategoryServices;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;
import ru.dkalugin.ImperiyaMetizov.services.SubcategoryServices;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ProductServices productService;
    private CategoryServices categoryServices;
    private SubcategoryServices subcategoryServices;
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String cart(Model model){
        model.addAttribute("greeting", new FormFooter());
        model.addAttribute("cart", cart.getProductList());
        return "cart";
    }

    @GetMapping("/add/{id}/{category_id}/{subcategory_id}")
    public String addShowCart(Model model, @PathVariable("id") Long id, @PathVariable("category_id") long category_id, @PathVariable("subcategory_id") Long subcategory_id){
        cart.addProductById(id);
        return "redirect:/product/" + subcategory_id + "/"  + category_id ;
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Long id){
        model.addAttribute("greeting", new FormFooter());
        cart.delete(id);
        model.addAttribute("cart", cart.getProductList());
        return "cart";
    }

}
