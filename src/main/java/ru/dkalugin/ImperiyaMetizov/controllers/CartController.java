package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.*;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

import javax.mail.MessagingException;
import java.io.IOException;
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
        model.addAttribute("form", new FormCart());
        model.addAttribute("cart", cart.getProductList());
        return "cart";
    }

    @GetMapping("/add/{id}/{category_id}/{subcategory_id}/{count}")
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

    @PostMapping("/send")
    public String buy(Model model, FormCart formCart) throws MessagingException, IOException {
        model.addAttribute("form", formCart);
        cart.send(formCart.getName(), formCart.getEmail(), formCart.getNumber(), formCart.getInn(), formCart.getNameOrg(), formCart.getDelivery());
        model.addAttribute("cart", cart.getProductList());
        cart.getProductList().clear();
        return "redirect:/cart";
    }

}
