package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteMapControllers {

    @GetMapping("/sitemap.xml")
    public String SiteMap(){
        return "sitemap.xml";
    }
}
