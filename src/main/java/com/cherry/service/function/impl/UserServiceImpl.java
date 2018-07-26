package com.cherry.service.function.impl;

import com.cherry.dao.UserDao;
import com.cherry.domain.User;
import com.cherry.service.function.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaoxiaoqing on 2018/7/25.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }
}
