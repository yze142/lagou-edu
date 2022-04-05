package topic;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;

/**
 * @program: xiaoyu-FastDFS
 * @description: 接收者一
 * @author: hello.xaioyu
 * @create: 2022-03-30 18:42
 **/

public class Receiver1 {
    public static void main(String[] args) throws Exception {
     //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //先声明队列
        channel.queueDeclare("xiaoyu",false,false,false,null);

        //绑定路由,第一个参数是队列名字，第二个是路由名字，第三个参数是接收消息的类型（可以绑定多个类型）
        channel.queueBind("xiaoyu","ss2","*.add");
        //接收消息
        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String s = new String(body);

                System.out.println("注册"+s);

            }
        };

        //监听队列
        channel.basicConsume("xiaoyu",true,consumer);




    }







}
