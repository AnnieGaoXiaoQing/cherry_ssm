package com.cherry.study.Multithreading.concurrentContainer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by gxq74_000 on 2019/1/20.
 */
public class ConcurrentQueue01 {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < 10; i++){
            strs.offer("a" + i); //add
        }

        System.out.println(strs.size());

        //取出第一个并删除
        System.out.println(strs.poll());
        System.out.print("poll = " + strs.size());

        System.out.println("-------------------------");

        //仅取出第一个
        System.out.println(strs.peek());
        System.out.println("peek = " + strs.size());
    }
}
