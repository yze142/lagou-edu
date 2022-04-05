package controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: kllRedis
 * @description: 测试秒杀活动
 * @author: hello.xaioyu
 * @create: 2022-03-27 17:34
 **/

@RestController
public class test {

    @Autowired
    Redisson redisson;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/test")
    public synchronized String  test(){
        //定义商品
        String productkey="HUAWEI-P40";

        //通过redisson获取锁
        RLock lock = redisson.getLock(productkey);
        //上锁（过期时间三十秒）
        lock.lock(30, TimeUnit.SECONDS);


        try {
            int phone = Integer.parseInt(stringRedisTemplate.opsForValue().get("phone"));

            if (phone>0){
               phone--;
              stringRedisTemplate.opsForValue().set("phone",phone+"");

                System.out.println("恭喜宁，抢购成功，还剩"+phone);

            }else {

                System.out.println("库存不足了");

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
            System.out.println("释放锁了");

        }

        return "ok";

    }


@Bean
    public Redisson redisson(){
    Config config=new Config();
    //使用单个redis服务器 第二个参数就是问你在哪个数据库做操作
    config.useSingleServer().setAddress("redis://192.168.58.132:6379").setDatabase(0);



  return (Redisson) Redisson.create(config);

}


}
