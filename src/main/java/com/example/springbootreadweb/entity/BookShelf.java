package com.example.springbootreadweb.entity;

import lombok.Data;

@Data
public class BookShelf {
    private Long id;

    private Long userId;

    private Long bookId;

    private Integer status;


}