package com.example.springbootreadweb.entity;

import lombok.Data;

@Data
public class Chapter {

    private Long id;

    private Long bookId;

    private String name;

    private Long contentId;

    private String type;

}