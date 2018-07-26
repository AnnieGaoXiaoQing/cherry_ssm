package com.cherry.dao;

import com.cherry.dao.base.MybatisDao;
import com.cherry.domain.User;

/**
 * Created by gaoxiaoqing on 2018/7/25.
 */
public interface UserDao{

    User selectUser(long id);

}
