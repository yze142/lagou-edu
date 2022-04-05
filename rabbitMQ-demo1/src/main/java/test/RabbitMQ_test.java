package test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import util.ConnectionUtil;

/**
 * @program: xiaoyu-FastDFS
 * @description: 点对点
 * @author: hello.xaioyu
 * @create: 2022-03-30 10:36
 **/

public class RabbitMQ_test {

    @Test
    public void RabbitmqSend() throws Exception {

        String n1="RabbitMQ";

        //1获取连接
        Connection connection = ConnectionUtil.getConnection();

        //2.连接中创建信道

        Channel channel=connection.createChannel();

        //3.创建消息队列(队列的名字，对列中的数据是否持久化，队列是否支持拓展，是否自动删除，队列参数)
        channel.queueDeclare("queue1",false,false,false,null);

        //4.向指定队列发送消息(交换机名称我们现在是点对点没有交换机捏，目标队列的名称，
        // 3设置消息的属性没有属性就是空的，，4消息内容(消息的内容值接收数组))
        for (int i=0;i<100;i++){

            channel.basicPublish("","queue1",null,n1.getBytes());
            System.out.println("已经发送资源"+i+"次");}



        //5.释放资源
      channel.close();
      connection.close();





    }

    public static void main(String[] args) throws Exception {
        RabbitMQ_test rabbitMQ_test=new RabbitMQ_test();

        rabbitMQ_test.RabbitmqSend();




    }





}
