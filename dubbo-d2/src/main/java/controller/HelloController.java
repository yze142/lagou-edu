package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.HelloService;

/**
 * @program: dubbo-d2
 * @description: 服务提供controller
 * @author: hello.xaioyu
 * @create: 2022-03-24 14:39
 **/
@Controller
public class HelloController {
    @Reference
    HelloService helloService;

    @GetMapping("hello")
    @ResponseBody
    public String hello(String dubbo){

        return helloService.sayHello(dubbo);
    }






}
