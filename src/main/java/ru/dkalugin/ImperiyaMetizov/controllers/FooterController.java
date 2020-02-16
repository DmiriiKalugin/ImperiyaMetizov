package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.Sendler;

import javax.mail.MessagingException;

@Controller
public class FooterController {
    Sendler sendler = new Sendler();

    @GetMapping("/privacy-policy")
    public String privacy_policy(Model model){
        model.addAttribute("greeting", new FormFooter());
        return "privacy_policy";
    }

    @PostMapping("/footer")
    public String index(@ModelAttribute FormFooter formFooter, Model model) throws MessagingException {
        model.addAttribute("greeting", formFooter);
        sendler.send(formFooter.getName(), formFooter.getNumber(), formFooter.getContent());
        return "index";
    }

}
