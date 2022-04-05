package com.lagou.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.UserCourseOrder;
import com.lagou.mapper.OrdeDao;
import com.lagou.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: lagou-edu-parent
 * @description: 订单
 * @author: hello.xaioyu
 * @create: 2022-04-05 10:27
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdeDao ordeDao;

    //创建订单类
    @Override
    public void saveOrder(String orderNo, String user_id, String course_id, String activity_course_id, String source_type) {

        ordeDao.saveOrde(orderNo, user_id, course_id, activity_course_id, source_type);



    }
    /**
     * 修改订单状态
     * @param orderNo 订单号
     * @param status 订单状态
     * @return
     */
    @Override
    public Integer updateOrder(String orderNo, Integer status) {
        return ordeDao.updateOrder(orderNo,status);
    }
    /**
     *
     * @param orderNo 订单
     * @return改变的行数
     */

    @Override
    public Integer deleteOrder(String orderNo) {
        return ordeDao.deleteOrder(orderNo);
    }

    /**
     * 根据登录的用户查询他的所有订单
     * @param user_id 用户id
     * @return 返回用户订单实体类捏
     */
    @Override
    public List<UserCourseOrder> getOrdersByUserId(String user_id) {
        return ordeDao.getOrdersByUserId(user_id);
    }
}
