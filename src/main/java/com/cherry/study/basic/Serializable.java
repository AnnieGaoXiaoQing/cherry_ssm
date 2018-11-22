package com.cherry.study.basic;

import com.alibaba.fastjson.JSON;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

public class Serializable {

    public static void main(String[] args) {
        //序列化
        /*Employee employee = new Employee();
        employee.setName("高晓青");
        employee.setAddress("石家庄市");
        employee.setPhoneNo("13716198967");*/

        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("33","第一");
        map.put("22","第二");
        String result = JSON.toJSONString(map);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test\\employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(result);
            out.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
