package com.cherry.study.java8;

import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、Lambda表达式
 * "—>"该操作符为称为箭头操作符或lambda操作符
 * 箭头操作符将lambda拆分为两部分
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需要执行的功能，即Lambda体
 * 小结：
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 * 二、Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法的接口
 *      可以使用注解@FunctionalInterface修饰，可以检查是否是函数式接口
 * Created by gxq74_000 on 2019/2/17.
 */
public class TestLambda2 {

    /**
     * 语法格式一：无参数，无返回值
     * ()—>System.out.println("Hello World!")
     */
    @Test
    public void test1(){
        int num = 0; // jdk1.7前必须是final(1.8默认加上了)

        //原来(匿名内部类)
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World" + num);
            }
        };
        r.run();
        System.out.println("=================================");

        //现在
        Runnable runnable = ()-> System.out.println("Hello World!");
        runnable.run();
    }

    /**
     * 语法格式二：有一参数，并且无返回值：(x) -> System.out.println(x);
     * 语法格式三：若只有一个参数，小括号可以省略不写：x -> System.out.println(x);（但不建议）
     */
    @Test
    public void test2(){
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("gaoxiaoqing");
    }

    /**
     * 语法格式四：有两个以上参数，有返回值，并且Lambda体中有多条语句
     */
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y)->{
            System.out.println("函数式编程");
            return Integer.compare(x,y);
        };

        //语法格式五：若Lambda体仅有一条语句，可省略Return和大括号
        Comparator<Integer> comparator = (x, y)->Integer.compare(x, y);

        //语法格式六：类型推断(Lambda表达式的参数列表的数据可以省略不写，因为JVM编译器通过上下文推断)
        Comparator<Integer> comparator1 = (Integer x, Integer y)->Integer.compare(x, y);

    }

    @Test
    public void test4(){
        //类型推断
        String[] strs = {"aa","bb","cc"};
    }

    /**
     * 对一个数进行运算
     */
    @Test
    public void test5(){
        Integer result = operate(100, x -> x * x);
        System.out.println("result = " + result);
    }

    public Integer operate(Integer num, MyFun myFun){
        return myFun.getValue(num);
    }
}
