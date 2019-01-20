package com.cherry.study.Multithreading;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * vector：同步容器，操作加锁
 * 存在问题：操作与判断分离
 * Created by gxq74_000 on 2019/1/19.
 */
public class TicketSeller2 {

    static Vector tickets = new Vector();

    static {
        for (int i = 0; i < 10000; i++) tickets.add("号编号" + i);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(()->{
                //判断和同步容器操作分离，会出错
                while (tickets.size() > 0){
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了：" + tickets.remove(10));
                }
            }).start();
        }
    }

}
