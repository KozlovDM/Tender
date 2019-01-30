package com.wallaby.tender.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private Double price;

    private String location;

    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Photo> photos;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Product() {
    }

    public Product(String name, Double price, String location, String description, List<Photo> photos, Client client) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.description = description;
        this.photos = photos;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
