package com.xiaoyu.meituan;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: test-zookeeper
 * @description: 客户类
 * @author: hello.xaioyu
 * @create: 2022-03-22 17:22
 **/

public class Cutomers {

    //zookeeper集群的ip和端口
    private String  connStr="192.168.58.129:2181,192.168.58.130:2181,192.168.58.131:2181";

    //session超时的时间
    private int session=60000;

    //zooker客户端对象
    private ZooKeeper zkClient;

    @Before
    public void init() throws Exception {
        zkClient = new ZooKeeper(connStr, session, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
               /* System.out.println("得到监听反馈");
                System.out.println(watchedEvent.getType());*/
                //发生变化后 再次获取商家列表
                try {
                    getShop();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }
    //获取所有商家
    public  void getShop() throws Exception {
        //获取服务器的子节点信息，然后对父节点进行监听
        List<String> shops = zkClient.getChildren("/meituan", true);
        //声明储存服务器信息的集合
        ArrayList<String> shopList=new ArrayList<>();
        for (String shop : shops) {
           //获取子节点上的值，（就是获取到商家的商品信息）
            byte[] data = zkClient.getData("/meituan/" + shop, false, new Stat());
            shopList.add(new String(data));

        }
        System.out.println("目前正在营业的商家"+shops+"商品有"+shopList);


    }





    public static void main(String[] args) throws Exception {
        Cutomers cutomers=new Cutomers();
         //获得zooker的连接，用户打开美团的操作
        cutomers.init();

        //获取meituan下的所有节点，获取商家·
      cutomers.getShop();

      //业务逻辑处理（对比商家，下单）
        cutomers.business();








    }

    private void business() throws Exception {

        System.out.println("用户正在浏览商家...A");
        System.in.read();

    }


}
