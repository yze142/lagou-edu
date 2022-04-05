package com.xiaoyu.test;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @program: xiaoyu-dedis
 * @description:
 * @author: hello.xaioyu
 * @create: 2022-03-27 14:22
 **/

public class TestJedis {


    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.58.132",6379);

        Set<String> keys = jedis.keys("*");

        Iterator<String> iterator = keys.iterator();

      /*  for (String key : keys) {


            System.out.println(key+"->"+jedis.get(key));
        }


        for(keys.iterator(); iterator.hasNext();){
            String next = iterator.next();

            System.out.println(next+"->"+jedis.get(next));


        }*/

        jedis.set("k2","ll");

        System.out.println(jedis.mget("k1","k2","k0"));


    }




}
