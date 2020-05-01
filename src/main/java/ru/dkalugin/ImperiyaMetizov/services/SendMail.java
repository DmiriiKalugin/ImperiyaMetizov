package ru.dkalugin.ImperiyaMetizov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.dkalugin.ImperiyaMetizov.config.MailConfig;
import ru.dkalugin.ImperiyaMetizov.config.PropertiesMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class SendMail {


    @Autowired
    public JavaMailSender emailSender;

    String name;

    String number;

    String  email;

    String content;

    public void send(String name, String number,String email, String content) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.content = content;


        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(PropertiesMail.MY_EMAIL);
        message.setTo(PropertiesMail.FRIEND_EMAIL);
        message.setSubject(PropertiesMail.SUBJECT);
        message.setText("Клиент: " + name + "\n" + "телефон: " + number + "\n" + "почта: " + email + "\n" + "сообщение: " + content);

        this.emailSender.send(message);
    }
}
