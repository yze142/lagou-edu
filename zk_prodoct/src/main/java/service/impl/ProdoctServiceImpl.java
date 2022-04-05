package service.impl;

import mapper.OrderMapper;
import mapper.ProducMapper;
import models.Order;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProdoctService;

import java.awt.print.Pageable;
import java.util.UUID;

/**
 * @program: test-zookeeper
 * @description: 实现
 * @author: hello.xaioyu
 * @create: 2022-03-22 23:11
 **/
@Service
public class ProdoctServiceImpl implements ProdoctService {
@Autowired
    ProducMapper producMapper;
@Autowired
    OrderMapper orderMapper;

  //减库存
    @Override
    public void reduceStock(int id) {
        //先查询商品是否存在
        Product product = producMapper.getProduct(id);
        if(product.getStock() <= 0){
            throw new RuntimeException("已抢光！");
        }
        //2.减库存
        int i = producMapper.reduceStock(id);
        if(i == 1){
            //3.生成订单
            Order order = new Order();
            order.setId(UUID.randomUUID().toString() ); //使用UUID工具帮我们生一个订单号
            order.setPid(id);
            order.setUserid(101);
            orderMapper.insert(order);
        }else{
            throw new RuntimeException("减库存失败！");





    }
}}
