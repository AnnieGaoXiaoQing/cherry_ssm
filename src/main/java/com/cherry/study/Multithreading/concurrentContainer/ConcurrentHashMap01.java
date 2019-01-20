package com.cherry.study.Multithreading.concurrentContainer;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 计算不同情况运行时间
 * Created by gxq74_000 on 2019/1/20.
 */
public class ConcurrentHashMap01 {

    public static void main(String[] args) {
        //高并发
        /*Map<String,String>  map =  new ConcurrentHashMap<>();
        Map<String,String> map = new ConcurrentSkipListMap<>();//高并发有序*/

        //普通
        Map<String,String>  map = new Hashtable();
       /* Map<String,String> map = new HashMap<>();*/

        Random random = new Random();
        Thread[] rs = new Thread[100];

        CountDownLatch countDownLatch = new CountDownLatch(rs.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i< 100;i++){
            rs[i] = new Thread(()->{
               for (int j = 0; j < 10000; j++){
                   map.put("a" + random.nextInt(100000),"a" + random.nextInt(100000));
                   countDownLatch.countDown();
               }
            });
        }

        Arrays.asList(rs).forEach(t->t.start());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }

}
