package listener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.listener.adapter.AbstractAdaptableMessageListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.ObjectInputFilter;

/**
 * @program: xiaoyu-FastDFS
 * @description: 监听类
 * @author: hello.xaioyu
 * @create: 2022-03-30 22:56
 **/
@Component
public class Consumer extends AbstractAdaptableMessageListener {


    //jackoson提供的序列化类
    private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //将message对象转化成JSON串
        try {
            JsonNode jsonNode = objectMapper.readTree(message.getBody());
            String name = jsonNode.get("name").asText();
            String age = jsonNode.get("age").asText();
            System.out.println(name);
            System.out.println(age);


            Thread.sleep(3000);
            System.out.println("休息三秒");
            //手动确认消息
            /*参数1：RabbitMQ向该channel投敌这条消息的唯一表述id
            参数二：小于等于myqId的所有消息
            * */
            long deliveryTag = message.getMessageProperties().getDeliveryTag();

            channel.basicAck(deliveryTag,true);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
