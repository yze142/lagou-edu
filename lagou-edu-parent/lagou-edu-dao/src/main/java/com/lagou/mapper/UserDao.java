package com.lagou.mapper;




import com.lagou.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-02 13:28:53
 */
@Service
public interface UserDao {



    //登录方法
    public User login(@Param("phone") String phone,@Param("password") String password);


    //判断·用户是否注册过账号，注册过就扣1
    public Integer checkPhone(String phone);

    //注册用户

    /**
     *
     * @param phone 手机号
     * @param password ，密码
     * @return
     */
    public Integer  register(@Param("phone") String phone,@Param("password") String password);













}

