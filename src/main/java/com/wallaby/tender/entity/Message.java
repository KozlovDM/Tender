package com.wallaby.tender.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Client from;

    @OneToOne(fetch = FetchType.EAGER)
    private Client to;

    private String text;

    private Date date;

    public Message() {
    }

    public Message(Client from, Client to, String text, Date date) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getFrom() {
        return from;
    }

    public void setFrom(Client from) {
        this.from = from;
    }

    public Client getTo() {
        return to;
    }

    public void setTo(Client to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
