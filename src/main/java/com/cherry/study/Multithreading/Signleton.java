package com.cherry.study.Multithreading;

import java.util.Arrays;

/**
 * 不加锁也可实现单例
 * Created by gxq74_000 on 2019/1/19.
 */
public class Signleton {

    private Signleton(){
        System.out.println("Signleton");
    }

    private static class Inner{
        private static Signleton s = new Signleton();
    }

    public static Signleton getSingler(){
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[100];
        for(int i = 0; i < ths.length; i++){
            ths[i] = new Thread(()->{
                Signleton.getSingler();
            });
        }

        Arrays.asList(ths).forEach(o->o.start());
    }
}
