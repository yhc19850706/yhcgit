package com.yhc.lifeall.service;


import com.yhc.lifeall.model.sysdata.User;

public interface UserService {
    User queryUserByUserName(String UserName);

    void insertUser(User user);
}
