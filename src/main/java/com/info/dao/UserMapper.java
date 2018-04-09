package com.info.dao;

import com.info.model.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findByUserName(String userName);

    void registUser(User user);
}