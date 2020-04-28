package ru.dkalugin.ImperiyaMetizov.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.dkalugin.ImperiyaMetizov.config.MailConfig;
import ru.dkalugin.ImperiyaMetizov.config.PropertiesMail;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    @Autowired
    public JavaMailSender emailSender;

    String name ;
    String number;
    String email;
    String inn;
    String nameOrg;
    String delivery;

    List<Product> productList;

    private ProductServices productServices;

    @Autowired
    public void setProductServices(ProductServices productServices) {
        this.productServices = productServices;
    }

    public List<Product> getProductList(){
        return productList;
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
    }

    public void addProductById(long id){
        Product product = productServices.getProductById(id);
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getId() == id){
                productList.get(i).setCount(getProductList().get(i).getCount() + 1);
                return;
            }
        }
        productList.add(product);
    }

    public void delete(long id){
       for (int i = 0; i < productList.size(); i++){
           if (productList.get(i).getId() == id){
               productList.remove(i);
               return;
           }
       }
    }

    public void send(String name, String number, String email, String inn, String nameOrg, String delivery) throws MessagingException, IOException {
        this.name = name;
        this.number = number;
        this.email = email;
        this.inn = inn;
        this.nameOrg = nameOrg;
        this.delivery = delivery;

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(PropertiesMail.FRIEND_EMAIL);
        helper.setSubject(PropertiesMail.CART_SUBJECT);

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i<getProductList().size(); i++){
            stringList.add(i+1 + "." + " - " + getProductList().get(i).getName()
                    + " количество: " + getProductList().get(i).getCount() + " шт.");
        }

        final String replace = stringList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", System.lineSeparator());


        helper.setText(replace + "\n"
                + "\n" + "Клиент: " + name + "\n" + "телефон: " + number + "\n" + "почта: " + email
                + "\n" + "ИНН организации: " + inn + "\n" + "Наименование организации: " + nameOrg
                + "\n" + "Адрес доставки: " + delivery);


        emailSender.send(message);
    }

}
