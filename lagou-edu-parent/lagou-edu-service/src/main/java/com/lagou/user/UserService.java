package com.lagou.user;

import com.lagou.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-04-02 13:29:02
 */
public interface UserService {

    //用户登录
    public User login(String phone,String password);

     //判断用户是否有账号
    public Integer checkPhone(String phone);

    //注册用户
    public Integer register(String phone,String password);




}
