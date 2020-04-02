package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Properties;

@Service
public class SendMail {

    String name;

    String number;

    String  email;

    String content;

    public void send(String name, String number,String email, String content) throws MessagingException {
        this.name = name;
        this.number = number;
        this.email = email;
        this.content = content;


        Properties properties = new Properties();
        //Хост или IP-адрес почтового сервера
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        //Требуется ли аутентификация для отправки сообщения
        properties.put("mail.smtp.auth", "true");
        //Порт для установки соединения
        properties.put("mail.smtp.socketFactory.port", "465");
//        //Фабрика сокетов, так как при отправке сообщения Yandex требует SSL-соединения
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        //Создаем соединение для отправки почтового сообщения
        Session session = Session.getDefaultInstance(properties,
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
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("imperiya-metizov@yandex.ru"));
        //Тема письма
        message.setSubject("Заявка с сайта imperiya-metizov.ru " + name);
        //Текст письма
        message.setText("Клиент: " + name + "\n" + "телефон: " + number + "\n" + "почта: " + email + "\n" + "сообщение: " + content);
        //Поехали!!!
        Transport.send(message);
    }
}
