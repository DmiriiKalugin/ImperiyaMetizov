package ru.dkalugin.ImperiyaMetizov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.CategoryServices;
import ru.dkalugin.ImperiyaMetizov.services.FormFooter;
import ru.dkalugin.ImperiyaMetizov.services.OrganizationServices;

import java.util.List;

@Controller
public class IndexController {
    private CategoryServices categoryServices;
    private OrganizationServices organizationServices;

    @Autowired
    public void setOrganizationServices(OrganizationServices organizationServices) {
        this.organizationServices = organizationServices;
    }

    @Autowired
    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/")
    public String index(FormFooter formFooter, Model model) {
        model.addAttribute("organization", organizationServices.getAllOrganization());
        List<Category> allCategory = categoryServices.getAllCategory();
        model.addAttribute("category", allCategory);
        model.addAttribute("greeting",formFooter);
        return "index";
    }


}
