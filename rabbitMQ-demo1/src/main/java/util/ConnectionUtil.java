package util;



import org.junit.Test;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



/**
 * @program: xiaoyu-FastDFS
 * @description: RabbitMQ连接工具类
 * @author: hello.xaioyu
 * @create: 2022-03-29 17:27
 **/

public class ConnectionUtil {


    public static Connection getConnection() throws Exception {

         //创建连接工厂
        ConnectionFactory factory=new ConnectionFactory();
        //在工厂对象中设置mq的链接属性
        factory.setHost("192.168.58.133");
        factory.setPort(5672);
        factory.setVirtualHost("/xiaoyu");
        factory.setUsername("yze142");
        factory.setPassword("123456");
     //通过工厂获取和MQ的连接
        //3.通过工厂获得与MQ的连接
     return factory.newConnection();

    }

         @Test
    public void test() throws Exception {

             Connection connection = ConnectionUtil.getConnection();

             System.out.println(connection);
             connection.close();


         }


}
