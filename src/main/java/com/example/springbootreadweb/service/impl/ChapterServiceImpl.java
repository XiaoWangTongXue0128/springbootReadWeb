package com.example.springbootreadweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.entity.Chapter;
import com.example.springbootreadweb.mapper.ChapterMapper;
import com.example.springbootreadweb.service.ChapterService;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
        implements ChapterService {
}
