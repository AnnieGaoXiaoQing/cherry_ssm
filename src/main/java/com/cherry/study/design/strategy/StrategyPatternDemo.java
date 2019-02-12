package com.cherry.study.design.strategy;

public class StrategyPatternDemo {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println("10+5 = " + context.executeStrategy(10, 5));

        Context contextSub = new Context(new OperationSubstract());
        System.out.println("10-5 = " + contextSub.executeStrategy(10, 5));
    }

}
