package com.cherry.study.aop;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class JdkProxyHandler {

    /**
     * 用来接收真实的对象
     */
    private Object realStar;

    /**
     * 通过构造方法传入真实的明星对象
     * @param star
     */
    public JdkProxyHandler(Star star) {
        super();
        this.realStar = star;
    }

    public Object getProxyInstance(){

        //参数1：目标对象的类加载器  参数2：目标对象实现的接口类型   参数3：动态处理器
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
            realStar.getClass().getInterfaces(),(proxy,method,args) ->{
            System.out.println("代理先进行谈判");
            Object object = method.invoke(realStar,args);
            System.out.println("演出完代理去收钱……");
            return object;
        });
    }

    public static void main(String[] args) {
        Star realStar = new RealStar();
        //创建代理实例对象
        Star proxy = (Star)new JdkProxyHandler(realStar).getProxyInstance();
        proxy.sing();
    }
}
