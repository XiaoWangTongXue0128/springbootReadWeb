package com.example.springbootreadweb.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ChapterContent {

    private Long id;

    private String content;

}