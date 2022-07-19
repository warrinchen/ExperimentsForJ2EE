package com.exp.service.impl;

import com.exp.entity.User;
import com.exp.mapper.UserMapper;
import com.exp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username, String password){
        return userMapper.getUser(username, password);
    }
}
