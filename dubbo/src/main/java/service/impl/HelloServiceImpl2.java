package service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import service.HelloService;

/**
 * @program: test-zookeeper
 * @description: 实现类
 * @author: hello.xaioyu
 * @create: 2022-03-23 23:03
 **/
@Service
public class HelloServiceImpl2 implements HelloService {
    @Override
    public String sayHello(String dubbo) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



        System.out.println("2.0版本被调用了");

        return "Hello"+dubbo;
    }
}
