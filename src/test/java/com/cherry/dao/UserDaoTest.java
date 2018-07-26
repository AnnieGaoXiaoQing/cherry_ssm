package com.cherry.dao;

import com.alibaba.druid.support.json.JSONUtils;
import com.cherry.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Created by gaoxiaoqing on 2018/7/26.
 */
//加载Spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testUserDao(){
        System.out.println("start");
        User user = userDao.selectUser(1L);
        System.out.println("result == " + JSONUtils.toJSONString(user));
    }

}
