package com.cherry.study.Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * threadLocal是用空间换时间，synchronized使用时间换空间
 * hibernate中的session就存在ThreadLocal中
 * Created by gxq74_000 on 2019/1/19.
 */
public class ThreadLocal2 {

    static ThreadLocal<Person> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal.set(new Person());
        }).start();
    }

    static class Person{
        String name = "高小青";
    }
}
