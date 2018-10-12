package com.cherry.study.java8.basic.operate;

public class Apple {
    /**
     * 重量
     */
    private int weight;
    /**
     * 颜色
     */
    private String color;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
