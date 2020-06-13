package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.OrganizationServices;

@Controller
public class DeliveryController {
    private OrganizationServices organizationServices;

    @Autowired
    public void setOrganizationServices(OrganizationServices organizationServices) {
        this.organizationServices = organizationServices;
    }


    @GetMapping("/delivery")
    public String delivery(Model model){
        model.addAttribute("organization", organizationServices.getAllOrganization());
        model.addAttribute("greeting", new FormFooter());
        return "delivery";
    }

}
