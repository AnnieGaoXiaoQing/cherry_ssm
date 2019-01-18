package com.cherry.study.aop;

public class ProxyStar implements  Star {
    /**
     * 接收的真实明星对象
     */
    private Star star;

    /**
     * 传入真实对象
     * @param star
     */
    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("代理先进行谈判");
        this.star.sing();
        System.out.println("演出完代理去收钱");
    }

    public static void main(String[] args) {
        Star realStar = new RealStar();
        Star proxy = new ProxyStar(realStar);
        proxy.sing();
    }
}
