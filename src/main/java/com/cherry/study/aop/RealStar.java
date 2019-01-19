package com.cherry.study.aop;

public class RealStar implements Star {
    @Override
    public void sing() {
        System.out.println("明星唱歌");
    }
}
