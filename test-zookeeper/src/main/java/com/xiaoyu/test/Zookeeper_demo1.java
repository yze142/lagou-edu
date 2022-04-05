package com.xiaoyu.test;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Zookeeper_demo1 {

    //zookeeper集群的ip
    private String  connStr="192.168.58.129:2181,192.168.58.130:2181,192.168.58.131:2181";

    //session超时的时间
    private int session=60000;

    //zooker客户端对象
    private  ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connStr, session, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("得到监听反馈");
                System.out.println(watchedEvent.getType());
            }
        });


    }


    //创建节点
    @Test
    public void  createtest() throws InterruptedException, KeeperException {

        //参数一是要创建的目录，参数二就是创建的内容，参数三居室权限，参数4就是类型
        String s = zkClient.create("/xiaoyu/xiaoyu2", "xiaoyu666".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println( "已创建节点="+s);


    }

    //获取节点上的值
    @Test
    public void getjiedian() throws InterruptedException, KeeperException {
   //第三个参数就是获取到文件时返回的

        byte[] data = zkClient.getData("/xiaoyu", false, new Stat());

        String data1 = new String(data);
        System.out.println("获取到的节点值为："+data1);

    }

    //修改节点上的值
    @Test
    public void upDate() throws InterruptedException, KeeperException {
  //参数一就是要修改的东西 参数二·1就是要修改的值，参数三，，不管
        Stat stat = zkClient.setData("/xiaoyu", "修改成功".getBytes(), 0);


    }

    //查看子节
    @Test
    public void getChildren() throws InterruptedException, KeeperException {
        List<String> children = zkClient.getChildren("/usa/niuyue/huashengdun", false);
        for (String child : children) {
            System.out.print(child);
        }

        System.out.println(children);
    }

     //监听节点变化
    @Test
    public  void watchNode() throws InterruptedException, KeeperException, IOException {
      //监听节点
        List<String> children = zkClient.getChildren("/usa", true);
        for (String child : children) {
            System.out.println(child);
        }
        System.out.println(children);
        //让线程等待下去
        System.in.read();

    }



}
