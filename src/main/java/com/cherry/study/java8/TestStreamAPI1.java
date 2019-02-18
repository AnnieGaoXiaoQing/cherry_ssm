package com.cherry.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 */
public class TestStreamAPI1 {

    //创建Stream
    @Test
    public void test1(){
        //方式一：通过Collection系列集合提供的串行Stream()或并行parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //方式二：通过Arrays中的静态方法stream()获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);

        //方式三：通过Stream类中的静态方法of
        Stream<String> stream2 = Stream.of("aa","bb","cc");

        //方式四：创建无限流
        //a、迭代：(iterate)
        Stream<Integer> stream3 = Stream.iterate(0, (x)->x + 2);
        stream3.limit(10).forEach(System.out::println);

        //b、生成
        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }

}
