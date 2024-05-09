package com.example.springbootreadweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.entity.ChapterContent;
import com.example.springbootreadweb.mapper.ChapterContentMapper;
import com.example.springbootreadweb.service.ChapterContentService;
import org.springframework.stereotype.Service;

@Service
public class ChapterContentServiceImpl extends ServiceImpl<ChapterContentMapper, ChapterContent>
        implements ChapterContentService {
}
