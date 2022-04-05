package com.xiaoyu.test;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @program: xiaoyu-dedis
 * @description: jedis连接redis
 * @author: hello.xaioyu
 * @create: 2022-03-27 14:00
 **/

public class TestDedis {

    Jedis jedis=new Jedis("192.168.58.134",6379);

        @Test
        public void test(){

            String ping = jedis.ping();
            System.out.println(ping);


        }




}
