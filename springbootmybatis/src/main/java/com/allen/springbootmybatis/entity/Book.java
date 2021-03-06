package com.allen.springbootmybatis.entity;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2020-06-30 14:50:35
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -87368121100882054L;
    
    private Integer id;
    
    private String name;

    private String aliaseName;
    
    private String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(Integer id, String name, String aliaseName, String author) {
        this.id = id;
        this.name = name;
        this.aliaseName = aliaseName;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getAliaseName() {
        return aliaseName;
    }

    public void setAliaseName(String aliaseName) {
        this.aliaseName = aliaseName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aliaseName='" + aliaseName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}