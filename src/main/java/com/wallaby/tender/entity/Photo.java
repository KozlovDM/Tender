package com.wallaby.tender.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Photo() {
    }

    public Photo(String photo, Product product) {
        this.photo = photo;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo that = (Photo) o;
        return id == that.id &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, photo);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                '}';
    }
}
