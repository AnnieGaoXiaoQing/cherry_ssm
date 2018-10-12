package com.cherry.study.java8.basic.operate;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(80,"red"),
                new Apple(125,"green"),
                new Apple(160,"red"));

        //筛选重量超过150
        List<Apple> heaveApples =filterApples(appleList,new AppleHeavyWeightPredicate());
        System.out.println("heaveApples.result === " + JSON.toJSONString(heaveApples));
        //筛选颜色为绿色
        List<Apple> simpleApples = filterApples(appleList,new AppleSimpleWeightPredicate());
        System.out.println("simpleApples.result === " + JSON.toJSONString(simpleApples));
    }
    //筛选结果
    public static List<Apple> filterApples(List<Apple> appleList, ApplePredicate p){
        List<Apple> list = new ArrayList();
        for (Apple apple : appleList){
            if(p.test(apple)){
                list.add(apple);
            }
        }
        return list;
    }

}
