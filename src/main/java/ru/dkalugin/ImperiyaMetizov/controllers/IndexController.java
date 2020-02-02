package ru.dkalugin.ImperiyaMetizov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dkalugin.ImperiyaMetizov.entities.FormFooter;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;
import ru.dkalugin.ImperiyaMetizov.services.Sendler;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class IndexController {
    private Sendler sendler = new Sendler();
    private ProductServices productService;

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }



    @GetMapping("/")
    public String index(Model model) {
        List<Product> allProduct = productService.getAllProducts();
        model.addAttribute("product", allProduct);
        model.addAttribute("greeting", new FormFooter());
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute FormFooter formFooter, Model model) throws MessagingException {
        model.addAttribute("greeting", formFooter);
        sendler.send(formFooter.getName(), formFooter.getNumber(), formFooter.getContent());
        return "index";
    }
}
