package com.example.springbootreadweb.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    //    要和数据库中的表对应时需要实现Serializable，添加一个序列化ID

    private static final long serialVersionUID = 5230540011103233424L;

    private Long id;
    private String name;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
