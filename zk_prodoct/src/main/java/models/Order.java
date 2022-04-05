package models;

/**
 * @program: test-zookeeper
 * @description: 订单类
 * @author: hello.xaioyu
 * @create: 2022-03-22 23:06
 **/

public class Order {


    private String id;
    private int pid;
    private int userid;
    public Order() {
    }

    public Order(String id, int pid, int userid) {
        this.id = id;
        this.pid = pid;
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", pid=" + pid +
                ", userid=" + userid +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
