package com.allen.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

/**
 * @Auther: allen
 * @Date: 2020-06-07 09:19
 * @Description:
 */
public class Book {

    private String name;
    private String author;

    @JsonIgnore
    protected Float price;

    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
