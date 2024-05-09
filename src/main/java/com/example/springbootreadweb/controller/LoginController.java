package com.example.springbootreadweb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.example.springbootreadweb.entity.User;
import com.example.springbootreadweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String login() {

        return "login";
    }

    @PostMapping
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        System.out.println(">>>>>>"+username+password);
        // 接收表单 要进行参数有效性的验证
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "用户名或密码不能为空");
            return "login";
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", username);
        User user = userService.getOne(wrapper);
        if (user == null) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }

        if (!password.equals(user.getPassword())) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
        System.out.println(user);
        session.setAttribute("user", user);
        return "redirect:/index";
    }
}
