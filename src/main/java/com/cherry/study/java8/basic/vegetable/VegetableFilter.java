package com.cherry.study.java8.basic.vegetable;

import com.alibaba.fastjson.JSON;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VegetableFilter {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT),
                new Dish("beef",false,700,Dish.Type.MEAT),
                new Dish("chicken",false,400,Dish.Type.MEAT),
                new Dish("french",true,530,Dish.Type.OTHER),
                new Dish("rice",true,350,Dish.Type.OTHER),
                new Dish("season",true,120,Dish.Type.OTHER),
                new Dish("pizza",true,550,Dish.Type.OTHER),
                new Dish("prawns",false,300,Dish.Type.FISH),
                new Dish("salmon",false,450,Dish.Type.FISH)
        );

        List<String> threeHighCaloricDishNames = menu.stream()
                                                     .filter(dish -> dish.getCalories() > 300)
                                                     .map(Dish::getName)
                                                     .limit(3)
                                                     .collect(Collectors.toList());

        /*System.out.println(threeHighCaloricDishNames);*/

        //菜名长度
        List<Integer> dishNameLength = menu.stream()
                                           .map(Dish::getName)
                                           .map(String::length)
                                           .collect(Collectors.toList());
        /*System.out.println("result = " + dishNameLength);

        List<String> words = Arrays.asList("hello","world");
        List<String> uniqueCharacters = words.stream()
                                             .map(w -> w.split(""))
                                             .flatMap(Arrays :: stream)
                                             .distinct()
                                             .collect(Collectors.toList());

        System.out.println("uniqueCharacters = " + uniqueCharacters);*/



        /*List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> squares = numbers.stream()
                                       .map(n -> n * n)
                                       .collect(Collectors.toList());
        System.out.println("result = " + squares);*/

        //查被3整除
        /*List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);
        List<int[]> pairs = number1.stream()
                                   .flatMap(i -> number2.stream()
                                                        .filter(j ->(i + j) % 3 == 0)
                                                        .map(j ->new int[]{i,j})
                                   ).collect(Collectors.toList());
        System.out.println("pairs = " + JSON.toJSONString(pairs));*/

        //查第一个被3整除
        /*List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareByThree = numbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst();
        System.out.println("firstSquareByThree = " + JSON.toJSONString(firstSquareByThree));*/


    }
}
