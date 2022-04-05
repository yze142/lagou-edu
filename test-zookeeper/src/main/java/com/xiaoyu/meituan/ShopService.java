package com.xiaoyu.meituan;

import org.apache.zookeeper.*;
import org.junit.Before;

import java.io.IOException;
import java.util.List;

/**
 * @program: test-zookeeper
 * @description: 美团案例
 * @author: hello.xaioyu
 * @create: 2022-03-22 16:27
 **/

public class ShopService {

    //zookeeper集群的ip和端口
    private String  conn="192.168.58.129:2181,192.168.58.130:2181,192.168.58.131:2181";

    //session超时的时间
    private int sessionTime=60000;

    //zooker客户端对象
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(conn, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
              /*  System.out.println("得到监听反馈");
                System.out.println(watchedEvent.getType());*/
                //




            }
        });


    }

    //注册到美团
      public void createShop(String shopName) throws InterruptedException, KeeperException {
        //这里是选择的自动序号类型的节点，不过是暂时的，连接断了他就无了
          String s = zkClient.create("/meituan/shopName", shopName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE
                  , CreateMode.EPHEMERAL_SEQUENTIAL);

          System.out.println(shopName+"开始营业了"+s);



      }





    public static void main(String[] args) throws InterruptedException, KeeperException, IOException {
        //1先开一个饭店
        ShopService shop=new ShopService();

        //2.创建一个集群和美团进行联系
        shop.init();


        //3.和美团进行合作
        shop.createShop(args[0]);


        //4.业务逻辑处理(做生意)
        shop.business(args[0]);



    }

     public  void   business(String shopName) throws IOException {

         System.out.println(shopName+"正在营业中");
         System.in.read();


     }



}
