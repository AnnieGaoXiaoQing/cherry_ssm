package com.cherry.study.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //Lambda 表达式
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
}
