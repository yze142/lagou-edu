package test;

import com.rabbitmq.client.*;
import org.junit.Test;
import util.ConnectionUtil;

import java.io.IOException;

/**
 * @program: xiaoyu-FastDFS
 * @description: 消息接收者
 * @author: hello.xaioyu
 * @create: 2022-03-30 10:53
 **/

public class RabbitMQReceiver {
static int i=1;

    @Test
    public void Receiver() throws Exception {


        //1获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2.连接中创建信道
        Channel channel = connection.createChannel();
        //3.从信道中拿到消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override//重写父类里面的方法（1。收件人信息，2.信道标签，3.协议的配置，4.消息）
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //body就是队列的消息
                String s = new String(body);

                System.out.println("一号接收"+s+""+i+++"次");

            }

        };
        //监听队列，true自动消息确认，因为我们的消息不是一次性发完的，需要监听
           channel.basicConsume("queue1",true ,consumer);

    }

    public static void main(String[] args) throws Exception {

        RabbitMQReceiver rabbitMQReceiver=new RabbitMQReceiver();

        rabbitMQReceiver.Receiver();
        rabbitMQReceiver.Receiver2();

    }
    public void Receiver2() throws Exception {


        //1获取连接
        Connection connection = ConnectionUtil.getConnection();
        //2.连接中创建信道
        Channel channel = connection.createChannel();
        //3.从信道中拿到消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override//重写父类里面的方法（1。收件人信息，2.信道标签，3.协议的配置，4.消息）
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //body就是队列的消息
                String s = new String(body);
                System.out.println("二号接收"+s+""+i+++"次");

            }

        };
        //监听队列，true自动消息确认，因为我们的消息不是一次性发完的，需要监听
        channel.basicConsume("queue1",true ,consumer);

    }


}
