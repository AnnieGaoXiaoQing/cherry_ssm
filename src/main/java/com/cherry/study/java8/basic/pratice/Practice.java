package com.cherry.study.java8.basic.pratice;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alain = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brain","Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alain,2012,950)
        );

        //1、2011年所有交易，交易额降序
        /*List<Transaction> result1 = transactionList.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println("result1 = " + JSON.toJSONString(result1));*/
        //2、交易员都在哪些城市工作过
        /*List<String> result2 = transactionList.stream()
                                                   .map(transaction -> transaction.getTrader().getCity())
                                                   .distinct()
                                                   .collect(toList());
        System.out.println("result2 = " + JSON.toJSONString(result2));*/
        //3、找来自剑桥的交易员，按姓名排序
        /*List<Trader> result3 = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct() //Todo:不了解为什么？？？
                .sorted(Comparator.comparing(Trader :: getName))
                .collect(toList());
        System.out.println("result3 = " + JSON.toJSONString(result3));*/

        //4、返回所有交易员姓名字符串，按字母排序
        /*String traderStr = transactionList.stream()
                                        .map(transaction -> transaction.getTrader().getName())
                                        .distinct()
                                        .sorted()
                                        .reduce("",(n1,n2) ->n1 + n2);
        System.out.println("traderStr == " + traderStr);*/
        //5、是否存在在米兰工作的？ //false：
        //方式1
        /*boolean isMiLan = transactionList.stream().noneMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));*/
        //方式2
        /*Optional<Trader> trader = transactionList.stream()
                .map(Transaction::getTrader)
                .filter(trader1 -> "Milan".equals(trader1.getCity())).findAny();
        System.out.println("isMiLan == " + trader);*/
        //6、生活在剑桥的交易员所有交易额
        /*transactionList.stream().filter(transaction ->"Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getTrader)
                .forEach(System.out::println);*/
        //7、找交易额最高
        /*Optional<Integer> result = transactionList.stream().map(Transaction::getValue)
                                                           .reduce(Integer ::max);
        System.out.println("result = " + result);*/
        //8、找交易额最小的交易
        Optional<Transaction> transaction = transactionList.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println("result = " + transaction);
    }
}
