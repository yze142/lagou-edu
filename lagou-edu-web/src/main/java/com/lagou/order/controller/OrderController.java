package com.lagou.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.entity.UserCourseOrder;
import com.lagou.order.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @program: lagou-edu-web
 * @description: 订单
 * @author: hello.xaioyu
 * @create: 2022-04-05 10:36
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    //远程消费类
    @Reference
    private OrderService orderService;

    /**
     * @param user_id            用户id
     * @param course_id          课程Id
     * @param activity_course_id 是否为活动课程
     * @param source_type        订单来源
     * @return 返回一个订单编号
     */
    @RequestMapping("/saveOrder/{userid}/{courseid}/{acid}/{stype}")
    public String saveOrder(@PathVariable("userid") String user_id, @PathVariable("courseid") String course_id,
                            @PathVariable("acid") String activity_course_id, @PathVariable("stype") String source_type) {

        String orderNo = UUID.randomUUID().toString();

        orderService.saveOrder(orderNo, user_id, course_id, activity_course_id, source_type);


        return orderNo;
    }

    /**
     * 修改订单状态
     * @param orderNo 订单号
     * @param //status 订单状态
     * @return
     * 订单状态: 0已创建 10未支付 20已支付 30已取消 40已过期 '

     */
   @RequestMapping("updateOrder/{orderNo}")
    public Integer updateOrder(@PathVariable("orderNo") String orderNo){

        Integer status=20;

       Integer integer = orderService.updateOrder(orderNo, status);
       return integer;

   }


    /**
     *删除订单
     * @param orderNo 订单
     * @return改变的行数
     */
    @RequestMapping("/deleteOrder/{orderNo}")
    public Integer deleteOrder(@PathVariable String orderNo){

        Integer integer = orderService.deleteOrder(orderNo);

        return integer;

    }

    /**
     * 根据用户id查询订单
     * @param userid
     * @return
     */
    @RequestMapping("/getOrdersByUserId/{userid}")
    public List<UserCourseOrder> getOrdersByUserId(@PathVariable String userid){
        List<UserCourseOrder> ordersByUserId = orderService.getOrdersByUserId(userid);

        return ordersByUserId;


    }




}
