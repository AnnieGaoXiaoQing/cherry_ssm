package com.cherry.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作
 * 1、创建Stream
 * 2、中间操作
 * 3、终止操作
 */
public class TestStreamAPI2 {

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.11),
            new Employee(102,"李四",22,5555.55),
            new Employee(104,"王五",3,3333.33),
            new Employee(105,"赵六",55,1111.11),
            new Employee(106,"田七",22,4444.44)
    );

    /**
     * 筛选与切片
     * filter-接收lambda，从流中排除某些因素
     * limit-截断流，使元素不超过指定数量
     * skip（n)-跳过，返回一个扔掉前n个元素的流。若元素不足n个，则返回空流
     * distinct-筛选，去除重复元素
     */
    //内部迭代：由Stream API完成
    @Test
    public void test1(){
        //惰性求值或延迟加载
        //中间操作：不执行任何操作   有终止操作，才会执行中间操作
        Stream<Employee> stream = emps.stream()
                                      .filter(employee -> {
                                          System.out.println("中间操作不打印");
                                          return employee.getAge() > 20;
                                      });
        //终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> it = emps.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void testLimit(){
        emps.stream().filter(employee -> employee.getSalary() > 5000)
                     .limit(2)
                     .forEach(System.out::println);

        //选出前两个符合条件的即会终止，不遍历整个循环（一定程度提高效率）
        emps.stream().filter(employee -> {
            System.out.println("短路");
            return employee.getSalary() > 5000;
        })
        .limit(2)
        .forEach(System.out::println);
    }

    @Test
    public void testSkip(){
        emps.stream().filter(employee -> employee.getSalary() > 3000)
                     .skip(2)
                     .forEach(System.out::println);
    }

    @Test
    public void testDistinct(){
        emps.stream().filter(employee -> employee.getSalary() > 3000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 映射：
     * map-接收Lambda，将元素转换为其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将映射为新的元素
     * flatmap-接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个流
     *
     */
    @Test
    public void testMap(){
        List<String> list = Arrays.asList("aa","bb","cc","dd");

        list.stream()
                .map(str-> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    /**
     * flatmap-接收一个函数作为参数，将流中每个值都换成另一个流，然后把所有流连接成一个流
     * 即在一个流中
     * map、flatMap 类似于 集合的add和addAll
     */
    @Test
    public void testFlatMap(){
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        //嵌套流

        //使用Map:元素转流加入 {{a,a},{b,b},{c,c},{d,d}}
        Stream<Stream<Character>> streamStream = list.stream().map(TestStreamAPI2::filterCharacter);
        streamStream.forEach(characterStream -> {
            characterStream.forEach(System.out::println);
        });
        System.out.println("----------------------------------");

        //使用FlatMap:单个元素加入流  {a,a,b,b,c,c,d,d}
        Stream<Character> streamStream1 = list.stream().flatMap(TestStreamAPI2::filterCharacter);
        streamStream1.forEach(System.out::println);
    }


    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted()-自然排序（Comparable）-字典序
     * sorted(Comparator com) -定制排序（Comparator）
     */
    @Test
    public void testSort(){
        List<String> list = Arrays.asList("cc","dd","aa","bb");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("==================================");

        emps.stream()
                .distinct()
                .sorted((e1,e2)->{
                    if (e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        //-e1.getAge()代表降序
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }

}
