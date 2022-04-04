package com.lagou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.entity.User;
import com.lagou.entity.UserDTO;
import com.lagou.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: lagou-edu-web
 * @Author: GuoAn.Sun
 * @CreateTime: 2020-09-08 11:22
 * @Description:
 */

@RestController
@RequestMapping("user")
public class UserController2 {

    @Reference // 远程消费
    private UserService userService;

    @RequestMapping("/login")
    public UserDTO login(String phone, String password) {
        //状态反馈
        UserDTO userDTO=new UserDTO();

        Integer integer = userService.checkPhone(phone);

        if(integer==0){
            //没有注册，调用注册
            Integer register = userService.register(phone, password);
            if(register!=0){
                userDTO.setMessage("手机号未注册，系统已经帮你自动注册");
                userService.login(phone,password);
            }else {userDTO.setMessage("状态异常");}


        }


        User login = userService.login(phone, password);
        System.out.println("手机号为"+phone);
        System.out.println("密码为"+password);



        if (login!=null){
            userDTO.setState(200);
            userDTO.setMessage("登录成功");
            userDTO.setContent(login);

        }else {
            userDTO.setState(400);
            userDTO.setMessage("登录失败");


        }



        return userDTO;


    }

    





}
