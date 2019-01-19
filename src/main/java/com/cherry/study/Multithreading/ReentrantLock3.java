package com.cherry.study.Multithreading;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock(尝试锁定)
 * Created by gxq74_000 on 2019/1/19.
 */
public class ReentrantLock3 {

    Lock lock = new ReentrantLock();

    void m1(){
        lock.lock();

        try {
            for (int i = 0; i < 5; i++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //手动释放锁
            lock.unlock();
        }
    }

    /**
     * tryLock进行尝试锁定，不管锁定与否，方法都会进行
     * 可根据tryLock返回值来判断是否锁定
     * 可指定tryLock的时间，同时会抛出异常，将unlock放到finally中
     */
    void m2(){
        //方式1
        /*boolean locked = lock.tryLock();
        System.out.println("m2 …… ");
        if(locked) lock.unlock();*/

        //方式2
        boolean locked = false;
        try {
            locked = lock.tryLock(5,TimeUnit.SECONDS);
            System.out.println("tryLock, status = " + locked);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(locked) lock.unlock();
        }

    }

    public static void main(String[] args) {
        ReentantLock2 reentantLock2 = new ReentantLock2();

        new Thread(reentantLock2::m1).start();

    /*    try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        new Thread(reentantLock2::m2).start();
    }

}
