package ru.dkalugin.ImperiyaMetizov.entities;

import javax.persistence.Entity;

public class FormFooter {
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
