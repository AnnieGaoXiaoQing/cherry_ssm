package com.cherry.study.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 锁定队列：不出问题,但效率低
 * Created by gxq74_000 on 2019/1/20.
 */
public class TicketSeller3 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) tickets.add("号编号；" + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i<10;i++){
            new Thread(()->{
                while (true){
                    synchronized (tickets){
                        if (tickets.size() <= 0) break;

                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("销售了……" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
