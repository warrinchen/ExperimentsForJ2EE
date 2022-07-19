package com.exp.service;

import com.exp.entity.User;

import java.util.Map;

public interface UserService {
    User getUser(String username, String password);
}
