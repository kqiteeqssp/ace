package com.info.service.impl;

import com.info.dao.UserMapper;
import com.info.model.User;
import com.info.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    public void registUser(User user) {
        userMapper.registUser(user);
    }

}