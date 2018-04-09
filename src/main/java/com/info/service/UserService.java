package com.info.service;

import com.info.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUserName(String userName);

    void registUser(User user);
}