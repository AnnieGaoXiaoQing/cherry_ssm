package com.cherry.study.java8.basic.pratice;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void main(String[] args) {

        List<Person>  personList = Arrays.asList(
                new Person("小青",11),
                new Person("小蓝",15),
                new Person("小红",12)
        );

        //正序
        personList.stream().sorted(Comparator.comparing(Person :: getAge));
        System.out.println("sort = " + JSON.toJSONString(personList));

        //逆序
        personList.stream().sorted(Comparator.comparing(Person::getAge).reversed());
        System.out.println("reverse = " + JSON.toJSONString(personList));

    }

}
