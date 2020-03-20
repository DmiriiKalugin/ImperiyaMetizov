package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

@Controller
public class OrderController {
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/order")
    public String order(Model model){
        model.addAttribute("greeting", new FormFooter());
        model.addAttribute("cart", cart.getProductList());
        return "order";
    }


}
