package com.cherry.study.Multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * 存在问题，不同步（会出现多负的情况）
 * Created by gxq74_000 on 2019/1/19.
 */
public class TicketSeller1 {

    static List<String> tickets = new ArrayList<>();

    static {
        for(int i=0; i<10000; i++) tickets.add("票编号," + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
            new Thread(()->{
                while (tickets.size() > 0){
                    System.out.println("销售票数 =" + tickets.remove(0));
                }
            }).start();
        }
    }
}
