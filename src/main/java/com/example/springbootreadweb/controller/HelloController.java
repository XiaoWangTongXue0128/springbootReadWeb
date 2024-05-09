package com.example.springbootreadweb.controller;


import com.example.springbootreadweb.entity.Book;
import com.example.springbootreadweb.entity.User;
import com.example.springbootreadweb.service.BookService;
import com.example.springbootreadweb.service.UserService;
import com.example.springbootreadweb.util.JsoupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 声明处理的是json数据
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringBoot";
    }

    @RequestMapping("/thyme")
    public String thyme() {
        return "hello";
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/mybatisplus")
    @ResponseBody
    public List<User> mybatisplus() {
        List<User> list = userService.list();
        return list;
    }

    @Autowired
    private BookService bookService;

    @Autowired
    private JsoupUtil jsoupUtil;

    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook() {
        Book book = new Book();
        book.setName("末世黎明之前");
        book.setAuthor("小可石豆");
        book.setDescription("【【“甘当绿叶”千万征文大奖赛】参赛作品】当太阳消失之后，人类该何去何从。当科技停止之后，人类又该怎样生活");
        book.setStatus(1);
        book.setCount(129000);
        book.setType("科幻");
        bookService.save(book);
        long id = book.getId();

        String str = "https://www.biqooge.com/52_52017/";
        jsoupUtil.h1(str,id);

        return id + "";
    }
}
