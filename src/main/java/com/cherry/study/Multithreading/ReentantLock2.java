package com.cherry.study.Multithreading;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentantLock 必须手动释放锁
 * sychronized 异常情况，JVM会释放
 */
public class ReentantLock2 {

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
            lock.unlock();
        }
    }

    void m2(){
        lock.lock();
        System.out.println("m2 …… ");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentantLock2 reentantLock2 = new ReentantLock2();

        new Thread(reentantLock2::m1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(reentantLock2::m2).start();
    }
}
