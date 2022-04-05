package confim;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

/**
 * @program: xiaoyu-FastDFS
 * @description: 处理消息类
 * @author: hello.xaioyu
 * @create: 2022-03-31 10:42
 **/

public class MessageConfirm implements RabbitTemplate.ConfirmCallback {
    /**
     *
     * @param correlationData 消息相关数据对象（封装了消息的唯一id）
     * @param b 消息是否成功
     * @param s 异常信息
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            System.out.println("消息成功");
        }else {
            System.out.println("消息失败");

        }
        System.out.println(s+"我是异常信息");



    }
}
