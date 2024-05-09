package com.example.springbootreadweb.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootreadweb.entity.Author;
import com.example.springbootreadweb.mapper.AuthorMapper;
import com.example.springbootreadweb.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
        implements AuthorService {
}
