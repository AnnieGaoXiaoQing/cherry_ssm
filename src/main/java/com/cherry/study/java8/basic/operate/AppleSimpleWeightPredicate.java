package com.cherry.study.java8.basic.operate;

public class AppleSimpleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
