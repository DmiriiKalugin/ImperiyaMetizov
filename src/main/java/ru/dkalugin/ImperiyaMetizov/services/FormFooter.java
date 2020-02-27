package ru.dkalugin.ImperiyaMetizov.services;

import javax.validation.constraints.Size;

public class FormFooter {

    @Size(min = 2, max = 20)
    private String name;

    private String number;
    private String content;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
