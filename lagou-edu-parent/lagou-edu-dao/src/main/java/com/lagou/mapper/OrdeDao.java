package com.lagou.mapper;

import com.lagou.entity.UserCourseOrder;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service
public interface OrdeDao {




    //创建订单
    public void saveOrde(@Param("orderNo")String orderNo,@Param("user_id")String user_id,
       @Param("course_id")String course_id,@Param("activity_course_id")String activity_course_id,
       @Param("source_type")String source_type);

    /**
     * 修改订单
     * @param orderNo 订单号
     * @param status   订单状态: 0已创建 10未支付 20已支付 30已取消 40已过期 '
     * @return 返回一个改变的行数
     */
    public Integer  updateOrder(@Param("orderNo") String orderNo,@Param("status") Integer status);

    /**
     *
     * @param orderNo 订单
     * @return改变的行数
     */
    public Integer deleteOrder(String orderNo);

    /**
     * 根据用户id查询订单
     * @param user_id
     * @return
     */
    public List<UserCourseOrder> getOrdersByUserId(String user_id);



}
