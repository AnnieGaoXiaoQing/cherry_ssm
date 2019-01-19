package com.cherry.study.Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * 线程局部变量
 * Created by gxq74_000 on 2019/1/19.
 */
public class ThreadLocal1 {

    volatile static Person p = new Person(); //不加volatitle有时会出错

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lst1";
        }).start();

    }

}

class Person {
    String name = "高晓青";
}

