package com.cherry.study.java8;

/**
 * Created by gxq74_000 on 2019/2/17.
 */
@FunctionalInterface
public interface MyFunctionOperate<T, R>{

    R getValue(T t1, T t2);

}
