package com.lagou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.lagou.entity.User;
import com.lagou.entity.UserDTO;
import com.lagou.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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
public class UserController {

    @Reference // 远程消费
    private UserService userService;

    @GetMapping("login")
    public UserDTO login(String phone, String password) {
        UserDTO dto = new UserDTO();
        User user = null;
        System.out.println("phone = " + phone);
        System.out.println("password = " + password);

        // 检测手机号是否注册
        Integer i = userService.checkPhone(phone);
        if(i == 0){
            // 未注册，自动注册并登录
            Integer register = userService.register(phone, password);
            if (register!=0) {

                user = userService.login(phone, password);
                dto.setState(200); //200表示成功
                dto.setMessage("手机号尚未注册，系统已帮您自动注册，请牢记密码！");



            }else {
                dto.setState(500);
                dto.setMessage("环境异常！");



            }
        }else{
            user = userService.login(phone, password);
            if(user == null){
                dto.setState(300); //300表示失败
                dto.setMessage("帐号密码不匹配，登录失败！");

            }else{
                dto.setState(200); //200表示成功
                dto.setMessage("登录成功！");


            }
        }

        dto.setContent(user);
        return dto;
    }







}
