package com.example.springbootreadweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootreadweb.entity.BookShelf;

public interface BookShelfService extends IService<BookShelf> {

    boolean addToShelf(long userId, long bookId);

    boolean removeFromShelf(long userId, long bookId);
}
