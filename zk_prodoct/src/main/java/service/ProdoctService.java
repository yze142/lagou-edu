package service;

import models.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @program: test-zookeeper
 * @description:
 * @author: hello.xaioyu
 * @create: 2022-03-22 23:02
 **/

public interface ProdoctService {


    //减库存
    public void reduceStock(int id);







}
