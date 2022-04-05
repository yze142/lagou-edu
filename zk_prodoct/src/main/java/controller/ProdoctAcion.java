package controller;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProdoctService;

import java.sql.PreparedStatement;

/**
 * @program: test-zookeeper
 * @description: web
 * @author: hello.xaioyu
 * @create: 2022-03-22 22:44
 **/

@RestController
@Controller
public class ProdoctAcion {

    @Autowired
    private ProdoctService prodoctService;

    private String  connectString="192.168.58.129:2181,192.168.58.130:2181,192.168.58.131:2181";

    @RequestMapping("/product/reduce")
    public Object reduce(int id)throws Exception{
        // 重试策略 （1000毫秒试1次，最多试3次）
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        //1.创建curator工具对象
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        client.start();
        //2.根据工具对象创建“内部互斥锁 这里第二个参数就是路径
        InterProcessMutex lock=new InterProcessMutex(client,"/product_"+id);
       //加锁
        try {
            lock.acquire();
            prodoctService.reduceStock(id);
        } finally {
            //释放锁
              lock.release();
        }


        return "ok";

    }



}
