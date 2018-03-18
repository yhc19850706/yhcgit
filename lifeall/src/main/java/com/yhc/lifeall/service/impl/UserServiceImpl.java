package com.yhc.lifeall.service.impl;

import com.yhc.lifeall.mapper.sysdata.UserMapper;
import com.yhc.lifeall.model.sysdata.User;
import com.yhc.lifeall.model.sysdata.UserExample;
import com.yhc.lifeall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByUserName(String userName) {
        User user=new User();
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
