package com.example.springbootreadweb.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootreadweb.entity.BookRead;

public interface BookReadService extends IService<BookRead> {

    String readRecord(long userId,long bookId);
}
