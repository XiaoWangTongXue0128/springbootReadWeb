package com.example.springbootreadweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.common.ReadStatus;
import com.example.springbootreadweb.entity.BookRead;
import com.example.springbootreadweb.entity.BookShelf;
import com.example.springbootreadweb.mapper.BookReadMapper;
import com.example.springbootreadweb.mapper.BookShelfMapper;
import com.example.springbootreadweb.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookShelfServiceImpl extends ServiceImpl<BookShelfMapper, BookShelf>
        implements BookShelfService {

    @Autowired
    private BookReadMapper bookReadMapper;

    @Autowired
    private BookShelfMapper bookShelfMapper;

    // 当一本书被加入书架时  查询阅读记录   验证其状态    不存在即为未读
    // 存在查看是否已读完 获取阅读时间   根据阅读时间排序
    @Override
    public boolean addToShelf(long userId, long bookId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        wrapper.eq("book_id", bookId);
        BookRead bookRead = bookReadMapper.selectOne(wrapper);

        ReadStatus readStatus = ReadStatus.UNREAD;
        if (bookRead != null) {
            if (bookRead.getStatus() == ReadStatus.FINISH.getValue()) {
                readStatus = ReadStatus.FINISH;
            } else {
                readStatus = ReadStatus.READING;
            }
        }

        BookShelf bookShelf = new BookShelf();
        bookShelf.setUserId(userId);
        bookShelf.setBookId(bookId);
        bookShelf.setStatus(readStatus.getValue());
        bookShelfMapper.insert(bookShelf);
        return true;
    }


    @Override
    public boolean removeFromShelf(long userId, long bookId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", userId);
        wrapper.eq("book_id", bookId);
        bookShelfMapper.delete(wrapper);
        return true;
    }
}
