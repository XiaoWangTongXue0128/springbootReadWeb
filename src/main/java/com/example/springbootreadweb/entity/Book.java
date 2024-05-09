package com.example.springbootreadweb.entity;

import lombok.Data;

@Data
public class Book {
    private Long id;

    private String name;

    private String author;

    private Long authorId;

    private String description;

    private Integer count;

    private Integer status;

    private String type;
}