package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @program: xiaoyu-FastDFS
 * @description:
 * @author: hello.xaioyu
 * @create: 2022-03-31 10:11
 **/

public class Test {

    public static void main(String[] args) throws IOException {

        // 获得容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-rabbitmq-consumer.xml");
        // 让程序一直运行，别终止
       while (true){}


    }













}
