package com.cherry.study.Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * 使用synchronized实现
 * m1和m2锁定this对象，所以不会并行执行
 */
public class ReentrantLock1 {

    synchronized void m1(){
        for (int i=0;i<10;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    synchronized void m2(){
        System.out.println("m2 ……");
    }

    public static void main(String[] args) {

        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(reentrantLock1::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(reentrantLock1::m2).start();
    }

}

