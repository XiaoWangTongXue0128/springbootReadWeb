package com.example.springbootreadweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//与自己设计的登录界面有冲突
//@Controller
//public class SecurityController {
//
//    @GetMapping("/welcome")
//    public String welcome() {
//        return "security/welcome";
//    }
//
//    @GetMapping("/level1/{path}")
//    public String level1(@PathVariable("path") String path) {
//        return "security/level1/" + path;
//    }
//
//    @GetMapping("/level2/{path}")
//    public String level2(@PathVariable("path") String path) {
//        return "security/level2/" + path;
//    }
//
//    @GetMapping("/level3/{path}")
//    public String level3(@PathVariable("path") String path) {
//        return "security/level3/" + path;
//    }
//
//}
