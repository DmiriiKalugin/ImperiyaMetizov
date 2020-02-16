package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("greeting", new FormFooter());
        return "contact";
    }
}
