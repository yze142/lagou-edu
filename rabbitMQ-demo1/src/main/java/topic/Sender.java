package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

/**
 * @program: xiaoyu-FastDFS
 * @description: 重定向发送
 * @author: hello.xaioyu
 * @create: 2022-03-30 18:29
 **/

public class Sender {

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        //连接中创建信道
        Channel channel=connection.createChannel();
        //声明路由第一个是路由名，第二个就是路由类型
        //dtopic:类型统配
        channel.exchangeDeclare("ss2","topic");

        String add="用户";
        //参数一就是路由名字，参数二是要发送消息的的类型，参数三是属性
     channel.basicPublish("ss2","user.add",null,add.getBytes());
        System.out.println("已经发送了捏");

        channel.close();
        connection.close();



    }









}
