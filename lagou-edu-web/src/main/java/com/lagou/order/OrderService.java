package com.lagou.order;

import com.lagou.entity.UserCourseOrder;

import java.util.List;

//消费类
public interface OrderService {


    /**
     *
     * @param orderNo 订单
     * @param user_id 用户id
     * @param course_id 课程id
     * @param activity_course_id 课程是否是活动课程
     * @param source_type 订单来源
     */

    void saveOrder(String orderNo, String user_id, String course_id,
                   String activity_course_id, String source_type);


    /**
     * 修改订单状态
     * @param orderNo 订单号
     * @param status 订单状态
     * @return
     */
    Integer updateOrder(String orderNo,Integer status);


    /**
     *删除订单
     * @param orderNo 订单
     * @return改变的行数
     */
    Integer deleteOrder(String orderNo);

    /**
     * 根据用户id查询订单
     * @param user_id
     * @return
     */
    public List<UserCourseOrder> getOrdersByUserId(String user_id);


}
