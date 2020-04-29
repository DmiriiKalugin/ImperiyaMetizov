package ru.dkalugin.ImperiyaMetizov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.dkalugin.ImperiyaMetizov.entities.Category;
import ru.dkalugin.ImperiyaMetizov.services.*;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.utils.Cart;

import java.util.List;

@Controller
public class CatalogController {
    private ProductServices productService;
    private CategoryServices categoryServices;
    private SubcategoryServices subcategoryServices;
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

    @Autowired
    public void setProductService(ProductServices productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryServices(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @Autowired
    public void setSubcategoryServices(SubcategoryServices subcategoryServices) {
        this.subcategoryServices = subcategoryServices;
    }

    @GetMapping("/catalog")
    public String catalog(Model model) {
        model.addAttribute("organization", organizationServices.getAllOrganization());
        List<Category> allCategory = categoryServices.getAllCategory();
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("category", allCategory);
        model.addAttribute("greeting", new FormFooter());
        return "catalog";
    }

    @GetMapping("/subcategory")
    public String Subcategory(Model model){
        model.addAttribute("organization", organizationServices.getAllOrganization());
        model.addAttribute("subcategory", subcategoryServices.getSubcategory());
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("greeting", new FormFooter());
        return "subcategory";
    }

    @GetMapping("/showSubcategory/{id}")
    public String showSubcategory(Model model, @PathVariable("id") long id){
        model.addAttribute("organization", organizationServices.getAllOrganization());
        model.addAttribute("category", categoryServices.getCategoryId(id));
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("subcategory", subcategoryServices.findByCategoryId(id));
        model.addAttribute("subcategory_one", subcategoryServices.getCategory_id(id));
        model.addAttribute("greeting", new FormFooter());
        return "showSubcategory";
    }

    @GetMapping("/product/{id}/{category_id}")
    public String Product(Model model, @PathVariable("id") long id, @PathVariable("category_id") long category_id){
        model.addAttribute("count",new Product());
        model.addAttribute("organization", organizationServices.getAllOrganization());
        model.addAttribute("category", categoryServices.getCategoryId(category_id));
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("subcategory", subcategoryServices.getCategory_id(id));
        model.addAttribute("product", productService.getAllBySubcategoryId(id));
        model.addAttribute("greeting", new FormFooter());
        return "product";
    }

    @GetMapping("/showProduct/{id}/{subcategory_id}/{category_id}")
    public String showProduct(Model model, @PathVariable("id") long id, @PathVariable("subcategory_id") long subcategory_id, @PathVariable("category_id") long category_id){
        model.addAttribute("organization", organizationServices.getAllOrganization());
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("category", categoryServices.getCategoryId(category_id));
        model.addAttribute("cart", cart.getProductList());
        model.addAttribute("subcategory", subcategoryServices.getCategory_id(subcategory_id));
        model.addAttribute("greeting", new FormFooter());
        return "showProduct";
    }
}
