package ru.dkalugin.ImperiyaMetizov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.dkalugin.ImperiyaMetizov.config.MailConfig;
import ru.dkalugin.ImperiyaMetizov.entities.Product;
import ru.dkalugin.ImperiyaMetizov.services.ProductServices;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    @Autowired
    private MailConfig mailConfig;

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

    public void send(String name, String number, String email, String inn, String nameOrg, String delivery) throws MessagingException {
        this.name = name;
        this.number = number;
        this.email = email;
        this.inn = inn;
        this.nameOrg = nameOrg;
        this.delivery = delivery;

        //Создаем соединение для отправки почтового сообщения
        Session session = Session.getDefaultInstance(mailConfig.properties(),
                //Аутентификатор - объект, который передает логин и пароль
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("imperiya-metizov@yandex.ru", "KaTe120892");
                    }
                });

        //Создаем новое почтовое сообщение
        Message message = new MimeMessage(session);
        //От кого
        message.setFrom(new InternetAddress("imperiya-metizov@yandex.ru"));
        //Кому
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("sales@imperiya-metizov.ru"));

        //Тема письма
        message.setSubject("Заявка с сайта imperiya-metizov.ru " + name);
        //Текст письма

            message.setText("Заказ состоящий из " + getProductList().size() + " позиций" + " можно найти в панели заказов"
                    + "\n" + "Клиент: " + name + "\n" + "телефон: " + number + "\n" + "почта: " + email
                    + "\n" + "ИНН организации: " + inn + "\n" + "Наименование организации: " + nameOrg
                    + "\n" + "Адрес доставки: " + delivery
            );

        //Поехали!!!
        Transport.send(message);

    }

}
