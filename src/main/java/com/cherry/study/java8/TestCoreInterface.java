package com.cherry.study.java8;

import org.junit.Test;
import sun.reflect.misc.ConstructorUtil;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内置四大核心函数式接口
 * Consumer<T>:消费型接口  void accept(T t);   无返回值
 * Supplier<T>:供给型接口  T get()   无参有返回值
 * Function<T,R>:函数型接口   R apply(T t)  有参有返回值
 * Predicate<T>:断言型接口    boolean test(T t)
 * Created by gxq74_000 on 2019/2/17.
 */
public class TestCoreInterface {

    //consumer<T> 消费型接口
    @Test
    public void testConsumer() {
        happy(1000, (m) -> System.out.println("消费了 = " + m + "元"));
    }

    private void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * 供给型
     * Ctrl + Shift + O
     */
    @Test
    public void testSupplier() {
        List<Integer> integerList = getNumList(10, () -> (int)(Math.random() * 100));
        for (Integer num : integerList){
            System.out.println("result = " + num);
        }
    }

    //需求：产生指定个整数放入集合
    private List<Integer> getNumList(Integer num, Supplier<Integer> supplier) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer result = supplier.get();
            integerList.add(result);
        }
        return integerList;
    }

    @Test
    public void testFunction(){
       String result =  handlerStr("\t\t\t 高晓青",(str) -> str.trim());
        System.out.println("trim = " + result);
        //截取字符串
        String subResult = handlerStr("高晓青",(str)-> str.substring(0,1));
        System.out.println("sub = " + subResult);
    }

    //需求：用于处理字符串
    private String handlerStr(String str, Function<String, String> function){
        return function.apply(str);
    }

    @Test
    public void testPredicate(){
        List list = Arrays.asList("Hello", "atshangui","Lamda","ol");
        List<String> result = filterStr(list, (str)->str.length() > 2);

        for (String str : result){
            System.out.println("reslut = " + str);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String>  filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str : list){
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
