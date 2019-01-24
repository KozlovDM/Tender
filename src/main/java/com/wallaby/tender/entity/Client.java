package com.wallaby.tender.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String phoneNumber;

    private long rating;

    @ManyToMany
    private List<Product> favouriteProduct;

    public Client() {
    }

    public Client(String name, String phoneNumber, long rating, List<Product> favouriteProduct) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.favouriteProduct = favouriteProduct;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public List<Product> getFavouriteProduct() {
        return favouriteProduct;
    }

    public void setFavouriteProduct(List<Product> favouriteProduct) {
        this.favouriteProduct = favouriteProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
