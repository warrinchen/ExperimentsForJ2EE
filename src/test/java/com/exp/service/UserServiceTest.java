package com.exp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void getUser() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "123456");
        System.out.println(userService.getUser("admin","123456"));
    }
}