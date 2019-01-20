package com.cherry.study.Multithreading;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 完美实现
 * ConcurrentLinkedQueue：同步容器，不允许装空值
 * Created by gxq74_000 on 2019/1/20.
 */
public class TicketSeller4 {

    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 10000; i++) tickets.add("号票号：" + i);
    }

    public static void main(String[] args) {
        for (int i=0; i < 10; i++){
            new Thread(()->{
                while (true){
                    String result = tickets.poll();
                    if(result == null) break;
                    System.out.println("销售了：" + result);
                }
            }).start();
        }

    }

}
