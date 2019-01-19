package com.cherry.study.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyHandler implements MethodInterceptor{

    /**
     * 维护目标对象
     */
    private Object target;

    public Object getProxyInstance(final Object target){
        this.target = target;
        //enhancer是CGLIB中的字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        //将被代理对象设置成父类
        enhancer.setSuperclass(this.target.getClass());
        //回调方法，设置拦截器
       /* enhancer.setCallback(this);*/
        //动态创建一个代理类
        return enhancer.create();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }
}
