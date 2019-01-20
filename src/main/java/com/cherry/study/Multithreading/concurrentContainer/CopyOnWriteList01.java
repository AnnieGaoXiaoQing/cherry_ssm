package com.cherry.study.Multithreading.concurrentContainer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * 写时复制容器
 * 多线程环境下，写效率低，读效率高
 * 适合场景：写的很少，读的很多
 * Created by gxq74_000 on 2019/1/20.
 */
public class CopyOnWriteList01 {

    public static void main(String[] args) {
        /*List<String> lists = new ArrayList<>();  //并发有问题，没有加锁*/
        List<String> lists = new Vector<>();
        /*List<String> lists = new CopyOnWriteArrayList<>();  //写效率低*/

        Random random = new Random();
        Thread[] threads = new Thread[100];

        for (int i = 0;i < threads.length; i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        lists.add("j" + random.nextInt(10000));
                    }
                }
            };
            threads[i] = new Thread(runnable);
        }

        runAndComputerTime(threads);

        System.out.println("size = " + lists.size());
    }

    static void runAndComputerTime(Thread[] ths) {
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(thread -> thread.start());
        Arrays.asList(ths).forEach(thread -> {
            try {
                thread.join(); //等待主线程结束才会执行下面
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }

}
