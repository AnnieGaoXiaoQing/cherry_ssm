package com.cherry.study.Multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by gaoxiaoqing on 2018/8/2.
 */
public class ImplementJava8 {

    /**
     *  方式一：Runnable & Thread
     *  缺陷：在执行完任务之后无法获取执行结果
     */
   /* public static void main(String[] args) {
        //Runnable
        Runnable runnable = ()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("Runnable start, threadName = " + threadName);
        };
        runnable.run();

        //Thread
        Thread thread = new Thread();
        thread.start();
        System.out.println("thread start");
    }*/



    /**
     *  方式二：Callable(需要 FutureTask 实现类的支持，用于接收运算结果)
     *  Callable和Future：可获得结果
     *  Callable一般是和ExecutorService配合来使用的
     */
    /*public static void main(String[] args) {
        //Callable
        Callable<Integer> task = () ->{
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            }catch (InterruptedException e){
                throw new IllegalStateException("task interrupted",e);
            }
        };

        FutureTask<Integer> result = new FutureTask<>(task);

        new Thread(result).start();

        //2、接收运算后结果
        try {
            Integer sum = result.get();
            System.out.println("sum == " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }*/

    /**
     *  方式三：Future和FutureTask
     *  区别
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });

        try {
            System.out.println("result get === " + future.get());
            System.out.println("result getTime === " + future.get(3,TimeUnit.SECONDS));
            System.out.println("result isDone === " + future.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
