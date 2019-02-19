package com.cherry.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 终端操作
 */
public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee(101,"张三",18,9999.11, Employee.Status.BUSY),
            new Employee(102,"李四",22,5555.55,Employee.Status.FREE),
            new Employee(104,"王五",3,3333.33,Employee.Status.VOCATION),
            new Employee(105,"赵六",55,1111.11,Employee.Status.BUSY),
            new Employee(106,"田七",22,4444.44,Employee.Status.BUSY)
    );

    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素总个数
     * max-返回流中最大值
     * min-返回流中最小值
     */
    @Test
    public void test1(){

        boolean b1 = employees.stream()
                .allMatch((employee) -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println("allMatch = " + b1);

        boolean b2 = employees.stream()
                              .anyMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY));
        System.out.println("anyMatch = " + b2);


        boolean b3 = employees.stream().noneMatch(employee -> employee.getStatus().equals(Employee.Status.FREE));
        System.out.println("noneMatch=" + b3);

        Optional<Employee> optional = employees.stream()
                                               .sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()))
                                               .findFirst();
        System.out.println("findFirst = " + optional.get());

        Optional<Employee> optional1 = employees.stream()
                                                .filter(employee -> employee.getStatus().equals(Employee.Status.FREE))
                                                .findAny();
        System.out.println("findAny = " + optional1.get());

    }

    @Test
    public void test2(){
        Long count = employees.stream().count();
        System.out.println("count = " + count);

        Optional<Employee> optional = employees.stream().max((e1,e2)->e1.getSalary().compareTo(e2.getSalary()));
        System.out.println("max=" + optional);

        Optional<Double> optional1 = employees.stream().map(Employee::getSalary)
                                                         .min(Double::compare);
        System.out.println("min =" + optional1.get());

    }
}
