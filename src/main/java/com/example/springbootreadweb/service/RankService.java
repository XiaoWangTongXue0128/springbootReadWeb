package com.example.springbootreadweb.service;


import com.example.springbootreadweb.entity.Book;

import java.util.List;

public interface RankService {

    void recordSearchCount(long bookId);

    List<Book> rankSearchCount();
}
