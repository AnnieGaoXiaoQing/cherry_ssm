package com.cherry.study.Multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantLock可指定为公平锁
 * 公平锁：每个线程执行一次，再继续循环
 * 非公平锁：随机
 * Created by gxq74_000 on 2019/1/19.
 */
public class ReentrantLock5 extends Thread{
    //true：公平锁
    private static ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r1 = new ReentrantLock5();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
    }
}
