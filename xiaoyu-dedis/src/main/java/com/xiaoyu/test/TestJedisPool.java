package com.xiaoyu.test;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: xiaoyu-dedis
 * @description: 测试连接池
 * @author: hello.xaioyu
 * @create: 2022-03-27 16:03
 **/

public class TestJedisPool {



    public static void main(String[] args) {

        Jedis jedis = JedisPoolUtil.getJedis();

        Set<String> keys = jedis.keys("*");

        for (String key : keys) {
            System.out.println(key);
        }

        Jedis jedis2 = JedisPoolUtil.getJedis();

    }

}
