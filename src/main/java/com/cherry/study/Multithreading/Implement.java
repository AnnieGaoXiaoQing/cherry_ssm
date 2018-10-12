package com.cherry.study.Multithreading;

import javafx.concurrent.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程多种实现
 * 借鉴：https://www.cnblogs.com/dolphin0520/p/3949310.html
 * Created by gaoxiaoqing on 2018/8/2.
 */
public class Implement {

    /**
     *  方式一：Runnable & Thread
     *  缺陷：在执行完任务之后无法获取执行结果
     */
    public static void main(String[] args) {

    }



    /**
     *  方式二：Runnable & Callable
     *  Callable和Future：可获得结果
     *  Callable一般是和ExecutorService配合来使用的
     */


    /**
     *  方式三：Future和FutureTask
     *  区别
     */

}
