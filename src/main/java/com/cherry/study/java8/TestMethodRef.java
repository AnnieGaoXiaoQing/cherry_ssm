package com.cherry.study.java8;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若Lamda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * 可以理解为方法引用是Lambda表达式的另外一种表现形式
 * <p>
 * 三种语法形式：
 * 对象：：实例方法名
 * 类：：静态方法名
 * 类：：实例方法名
 *
 * 前提：lambda方法体的参数列表及返回值类型要与函数式接口的参数列表及返回值类型一致
 *
 * 二、构造器引用
 * 格式：ClassName::new
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 *
 * 三、数组引用
 * Type[]::new
 * Created by gxq74_000 on 2019/2/17.
 */
public class TestMethodRef {

    /**
     * 对象::实例名
     */
    @Test
    public void test1() {
        //方式1
        Consumer<String> con = (x) -> System.out.print(x);

        //方式2
        PrintStream ps2 = System.out;
        Consumer<String> con1 = ps2::println;

        //方式三
        Consumer<String> con2 = System.out::println;
        con2.accept("abcde");
    }

    @Test
    public void test2(){
        //日常形式
        Employee employee = new Employee();
        Supplier<String> supplier = ()->employee.getName();
        supplier.get();

        //方法引用形式
        employee.setName("高晓青");
        Supplier<String> sup2 = employee::getName;
        String name = sup2.get();
        System.out.println("name = " + name);
    }

    //类::静态方法名
    @Test
    public void test3(){
        //原来
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        //方法引用
        Comparator<Integer> com1 = Integer :: compare;
    }

    /**
     * 类::实例方法名
     * 若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
     */
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y)-> x.equals(y);

        //方法引用
        BiPredicate<String,String> bp1 = String :: equals;
    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = ()->new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Employee employee = sup2.get();  //匹配无参构造器，和函数式接口一致
        System.out.println(employee);
    }

    /**
     * 构造器引用（一入参，一返回值）
     */
    @Test
    public void test6(){
        //Lamda形式
        Function<Integer, Employee> fun = (x) ->new Employee(x);
        //构造器引用形式
        Function<Integer,Employee> fun1 = Employee::new;
        Employee employee = fun1.apply(101);
        System.out.println("employee = " + JSONArray.toJSONString(employee));
    }

    //数组引用
    @Test
    public void test7(){

        

    }
}
