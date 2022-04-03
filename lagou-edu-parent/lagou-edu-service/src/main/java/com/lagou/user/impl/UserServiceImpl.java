package com.lagou.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.User;
import com.lagou.mapper.UserDao;
import com.lagou.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-04-02 13:29:04
 */
@Service //引入dobbu的包暴露服务

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    //用户登录
    @Override
    public User login(String phone, String password) {

        User login = userDao.login(phone, password);

        return login;


    }

     //判断手机号是否注册过
    @Override
    public Integer checkPhone(String phone) {

        Integer integer = userDao.checkPhone(phone);


        return integer;
    }

    //注册
    @Override
    public Integer register(String phone, String password) {
        return userDao.register(phone, password);
    }


}
