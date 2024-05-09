package com.example.springbootreadweb.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.common.ReadStatus;
import com.example.springbootreadweb.entity.BookRead;
import com.example.springbootreadweb.entity.Chapter;
import com.example.springbootreadweb.entity.ChapterContent;
import com.example.springbootreadweb.mapper.BookReadMapper;
import com.example.springbootreadweb.mapper.ChapterContentMapper;
import com.example.springbootreadweb.mapper.ChapterMapper;
import com.example.springbootreadweb.service.BookReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookReadServiceImpl extends ServiceImpl<BookReadMapper, BookRead>
        implements BookReadService {

    @Autowired
    private BookReadMapper bookReadMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private ChapterContentMapper contentMapper;

    // 点击阅读
    // 判断是否存在阅读记录   如果不存在  新增
    // 章节为第一章   阅读时间是当前时间   阅读状态是正在读
    // 如果存在    获取阅读记录   找到对应章节   展示其内容
    // 最后阅读章节和最新更新章节的处理
    @Override
    public String readRecord(long userId, long bookId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        wrapper.eq("book_id", bookId);
        BookRead bookRead = bookReadMapper.selectOne(wrapper);
        if (bookRead == null) {
            bookRead = new BookRead();
            bookRead.setUserId(userId);
            bookRead.setBookId(bookId);

            wrapper = new QueryWrapper();
            wrapper.eq("sort", 1);
            Chapter chapter = chapterMapper.selectOne(wrapper);
            bookRead.setChapterId(chapter.getId());

            bookRead.setLastReadTime(new java.util.Date());
            bookRead.setStatus(ReadStatus.READING.getValue());
            bookReadMapper.insert(bookRead);

            ChapterContent content = contentMapper.selectById(chapter.getContentId());
            return content.getContent();
        }

        bookRead.setLastReadTime(new Date());
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("user_id", userId);
        updateWrapper.eq("book_id", bookId);
        bookReadMapper.update(bookRead, updateWrapper);

        Chapter chapter = chapterMapper.selectById(bookRead.getChapterId());
        ChapterContent content = contentMapper.selectById(chapter.getContentId());
        return content.getContent();
    }
}
