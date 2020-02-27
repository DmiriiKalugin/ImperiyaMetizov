package ru.dkalugin.ImperiyaMetizov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    List<Product> productList;

    private ProductServices productServices;

    @Autowired
    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    List<Product> getProductList(){
        return productList;
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
    }

    public void addProductById(long id){
        Product product = productServices.getProductById(id);
        productList.add(product);
    }
}
