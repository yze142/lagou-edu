package com.xiaoyu.mapper;




import com.xiaoyu.entity.User;
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










}

