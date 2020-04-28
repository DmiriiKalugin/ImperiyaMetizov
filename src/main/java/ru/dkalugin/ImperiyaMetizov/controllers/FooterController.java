package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.SendMail;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
public class FooterController {
    SendMail sendMail;

    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    @GetMapping("/privacy-policy")
    public String privacy_policy(Model model){
        model.addAttribute("greeting", new FormFooter());
        model.addAttribute("cart", cart.getProductList());
        return "privacy_policy";
    }

    @PostMapping("/footer")
    public String index(@ModelAttribute @Valid FormFooter formFooter,BindingResult bindingResult, Model model) throws MessagingException {
            model.addAttribute("greeting", formFooter);
            model.addAttribute("cart", cart.getProductList());
            sendMail.send(formFooter.getName(), formFooter.getNumber(), formFooter.getEmail(), formFooter.getContent());
            formFooter.setName(null);
            formFooter.setNumber(null);
            formFooter.setEmail(null);
            formFooter.setContent(null);
            return "redirect:/";

    }

}
