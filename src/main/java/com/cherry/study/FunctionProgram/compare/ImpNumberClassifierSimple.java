package com.cherry.study.FunctionProgram.compare;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gxq74_000 on 2018/12/15.
 */
public class ImpNumberClassifierSimple {

    private int _number;
    private Map<Integer, Integer> _cache;

    public ImpNumberClassifierSimple(int targetNumber){
        _number = targetNumber;
        _cache = new HashMap<>();
    }

    public boolean isFactor(int potential){
        return _number % potential == 0;
    }

   public Set<Integer>  getFactors(){
       Set<Integer> factors = new HashSet<>();
       factors.add(1);
       factors.add(_number);
       for(int i = 2; i < _number; i++){
           if(isFactor(i)){
               factors.add(i);
           }
       }
       return factors;
   }

    public int aliquoSum(){
        if(_cache.get(_number) == null){
            int sum = 0;
            for(int i : getFactors())
                sum++;
            _cache.put(_number, sum - _number);
        }
        return _cache.get(_number);
    }

    public boolean isPerfect(){
        return aliquoSum() == _number;
    }

    public boolean isAbudant(){
        return aliquoSum() > _number;
    }

    public boolean isDeficient(){
        return aliquoSum() < _number;
    }

    public static void main(String[] args) {

    }

}
