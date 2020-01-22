package ru.dkalugin.ImperiyaMetizov.controllers;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/catalog")
    public String catalog(){
        return "catelog";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/order_payment")
    public String order_payment(){
        return "/order_payment";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/delivery")
    public String delivery(){
        return "delivery";
    }


}
