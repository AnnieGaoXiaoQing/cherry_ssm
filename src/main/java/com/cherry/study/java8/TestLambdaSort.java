package com.cherry.study.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import javax.ejb.PostActivate;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gxq74_000 on 2019/2/17.
 */
public class TestLambdaSort {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.11),
            new Employee(102,"李四",22,5555.55),
            new Employee(104,"王五",3,3333.33),
            new Employee(105,"赵六",55,1111.11),
            new Employee(106,"田七",22,4444.44)
    );

    /**
     * 先按年龄排序，再按姓名排序
     */
    @Test
    public void test1(){
        Collections.sort(emps,(x1,x2) -> {
            if(x1.getAge() == x2.getAge()){
                return x1.getName().compareTo(x2.getName());
            }else {
                return Integer.compare(x1.getAge(),x2.getAge());
            }
        });

        for (Employee employee: emps){
            System.out.println("result == " + JSONArray.toJSONString(employee));
        }
    }

    @Test
    public void test2(){
        String trimStr = handlerString("\t\t\t 高晓青", x -> x.trim());
        System.out.println("result = " + trimStr);
    }


    private String handlerString(String str, MyFunciton myFunciton){
        return myFunciton.getValue(str);
    }

    //对于两个Long型数据进行处理
    @Test
    public void test3(){
        //加法
        caluateHandler(1L,2L, (x,y) -> x + y);
        //乘法
        caluateHandler(1L,2L, (x,y)->x * y);
    }

    private void caluateHandler(Long t1, Long t2, MyFunctionOperate<Long, Long> myFunctionOperate){
        System.out.println( myFunctionOperate.getValue(t1, t2));
    }
}
