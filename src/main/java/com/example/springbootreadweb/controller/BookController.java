package com.example.springbootreadweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootreadweb.entity.Book;
import com.example.springbootreadweb.service.BookService;
import com.example.springbootreadweb.service.RankService;
import com.example.springbootreadweb.vo.BookDetailVo;
import com.example.springbootreadweb.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private RankService rankService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/search")
//    @ResponseBody
    public String search(@RequestParam("keyword") String keyword, Model model) {
        System.out.println(keyword);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name", keyword);
        List<Book> list = bookService.list(wrapper);

        List<BookVo> voList = new ArrayList<>();
        for (Book book : list) {
            BookVo vo = new BookVo();
            vo.setId(book.getId());
            vo.setName(book.getName());
            vo.setAuthor(book.getAuthor());
            vo.setDesc(book.getDescription());
            vo.setImgPath(book.getId() + ".jpg");
            rankService.recordSearchCount(book.getId());
            voList.add(vo);
        }
        model.addAttribute("voList", voList);
        // 展示到列表页中
        return "list";
    }


    @RequestMapping("/detail/{bookId}")
    public String detail(@PathVariable String bookId, Model model) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", bookId);
        Book book = bookService.getOne(wrapper);
        BookDetailVo vo = new BookDetailVo();
        vo.setName(book.getName());
        vo.setAuthor(book.getAuthor());
        vo.setImgPath(book.getId() + ".jpg");
        vo.setDesc(book.getDescription());
        model.addAttribute("vo", vo);
        return "detail";
    }
}
