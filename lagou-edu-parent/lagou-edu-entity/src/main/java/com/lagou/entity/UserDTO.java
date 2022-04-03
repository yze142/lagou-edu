package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: lagou-edu-parent
 * @description: Dto
 * @author: hello.xaioyu
 * @create: 2022-04-03 16:46
 **/
@Data //setget方法
@AllArgsConstructor //有参
@NoArgsConstructor
@ToString
public class UserDTO<User> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int state;  // 操作状态
    private String message;  // 状态描述
    private User content;  // 响应内容






}
