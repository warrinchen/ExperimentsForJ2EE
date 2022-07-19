package com.exp.mapper;

import com.exp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    User getUser(@Param("username") String username, @Param("password") String password);
}
