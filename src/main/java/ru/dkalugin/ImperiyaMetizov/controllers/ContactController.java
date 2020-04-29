package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.entities.Organization;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.OrganizationServices;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

@Controller
public class ContactController {
    private Cart cart;
    private OrganizationServices organizationServices;

    @Autowired
    public void setOrganizationServices(OrganizationServices organizationServices) {
        this.organizationServices = organizationServices;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("greeting", new FormFooter());
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("organization", organizationServices.getAllOrganization());
        return "contact";
    }
}
