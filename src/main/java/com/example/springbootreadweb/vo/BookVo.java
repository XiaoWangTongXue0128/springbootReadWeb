package com.example.springbootreadweb.vo;

import lombok.Data;

@Data
public class BookVo {

    private Long id;
    private String name;
    private String author;
    private String imgPath;
    private String desc;

}
