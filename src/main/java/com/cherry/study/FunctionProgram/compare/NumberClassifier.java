package com.cherry.study.FunctionProgram.compare;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gxq74_000 on 2018/12/15.
 */
public class NumberClassifier {

    public static boolean isFactor(final int candiate,final int number){
        return number % candiate == 0;
    }

    public static Set<Integer> factors(final int number){
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for(int i = 2; i < number;i++){
            if(isFactor(i, number)){
                factors.add(i);
            }
        }
        return factors;
    }

    public static int aliquoSum(final Collection<Integer> facors){
        int sum = 0;
        int targetNumber = Collections.max(facors);
        for (int n : facors){
            sum += n;
        }
        return sum = targetNumber;
    }

    public static boolean isPerfect(final int number){
        return aliquoSum(factors(number))== number;
    }

    public static boolean isAbudant(final int number){
        return aliquoSum(factors(number)) == number;
    }

    public static boolean isDeficient(final int number){
        return aliquoSum(factors(number)) < number;
    }

}
