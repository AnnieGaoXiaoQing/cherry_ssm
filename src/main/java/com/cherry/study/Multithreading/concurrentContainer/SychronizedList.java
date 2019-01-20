package com.cherry.study.Multithreading.concurrentContainer;

import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给List加锁
 * Created by gxq74_000 on 2019/1/20.
 */
public class SychronizedList {

    public static void main(String[] args) {

        List<String> lists = new ArrayList<>();
        List<String> listsOnLock = Collections.synchronizedList(lists); //给List加锁

    }

}
