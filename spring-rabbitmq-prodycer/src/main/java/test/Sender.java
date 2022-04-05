package test;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: xiaoyu-FastDFS
 * @description: 生产者
 * @author: hello.xaioyu
 * @create: 2022-03-30 21:51
 **/

public class Sender {

    public static void main(String[] args) {
        //1.创建spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-prodycer.xml");
        //2.从容器中获得 rabbit模版对象
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        //发消息
        Map<String, String> map=new HashMap();
        map.put("name","xiaoyu");
        map.put("age","18");

        for (int i=1;i<10;i++) {
            rabbitTemplate.convertAndSend("msg.xiaoyu",map);
        }
        context.close();




    }




}
