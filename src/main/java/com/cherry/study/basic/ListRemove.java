package com.cherry.study.basic;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConcurrentModificationException
 */
public class ListRemove {

     static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        new Thread(){
            public void run(){
                Iterator<String> iterator = list.iterator();
                synchronized (list){
                    while (iterator.hasNext()){
                        System.out.println(Thread.currentThread().getName() + ":" + iterator.next());
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread(){
            public synchronized void run(){
                Iterator<String> iterator = list.iterator();
                synchronized (list){
                    while (iterator.hasNext()){
                        System.out.println(Thread.currentThread().getName() + ":" + iterator.next());
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

    }
}
