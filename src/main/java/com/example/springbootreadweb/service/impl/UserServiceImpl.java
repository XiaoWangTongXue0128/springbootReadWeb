package com.example.springbootreadweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootreadweb.entity.User;
import com.example.springbootreadweb.mapper.UserMapper;
import com.example.springbootreadweb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}
