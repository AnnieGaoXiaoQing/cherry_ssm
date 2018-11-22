package com.cherry.study.Multithreading;


import java.util.concurrent.CountDownLatch;

public class Player implements Runnable {

    private CountDownLatch begin;

    private CountDownLatch end;

    public Player(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            begin.await();
            System.out.println(Thread.currentThread().getName() + "arrived!");
            /*end.countDown();*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
