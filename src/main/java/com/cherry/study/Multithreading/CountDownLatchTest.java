package com.cherry.study.Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(4);

        for (int i=0; i < 4; i++){
            Thread thread = new Thread(new Player(begin, end));
            thread.start();
        }
        try {
            System.out.println("the race begin");
            begin.countDown();
            end.await();
            System.out.println("the race end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
