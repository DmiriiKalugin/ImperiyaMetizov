package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;

@Controller
public class DeliveryController {
    @GetMapping("/delivery")
    public String delivery(Model model){
        model.addAttribute("greeting", new FormFooter());
        return "delivery";
    }

}
