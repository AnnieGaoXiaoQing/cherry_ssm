package com.cherry.study.design.template;

public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();
        System.out.println(" ===================");
        Game football = new Football();
        football.play();

    }
}
