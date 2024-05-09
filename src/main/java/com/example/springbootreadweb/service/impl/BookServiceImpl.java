package com.example.springbootreadweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.entity.Book;
import com.example.springbootreadweb.mapper.BookMapper;
import com.example.springbootreadweb.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
        implements BookService {
}
