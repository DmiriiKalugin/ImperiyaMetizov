package ru.dkalugin.ImperiyaMetizov.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String image;

    private String name;

    private String description;

    private String price;

    private int subcategory_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public Product(String name, String price, int subcategory_id) {
        this.name = name;
        this.price = price;
        this.subcategory_id = subcategory_id;
    }


}
