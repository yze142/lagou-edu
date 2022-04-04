package com.lagou.user;

import com.lagou.entity.User;
/**
 * @BelongsProject: lagou-edu-web
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-08 11:21
 * @Description:
 */
public interface UserService {
    /**
     * @param phone    手机号
     * @param password 密码
     * @return 用户对象
     */
 public User  login(String phone, String password);


    //判断用户是否有账号
    public Integer checkPhone(String phone);

    //注册用户
    public Integer register(String phone,String password);



}
