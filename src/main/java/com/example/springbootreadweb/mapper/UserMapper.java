package com.example.springbootreadweb.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootreadweb.entity.User;
import com.example.springbootreadweb.entity.vo.GroupBean;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<GroupBean> selectGroup();

    List<User> selectByName(String name);
}
