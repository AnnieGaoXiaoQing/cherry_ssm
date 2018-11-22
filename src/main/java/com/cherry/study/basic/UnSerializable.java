package com.cherry.study.basic;

import com.cherry.study.vo.Employee;
import org.omg.CORBA.Environment;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnSerializable {

    public static void main(String[] args) {
        /*Employee employee = null;*/
        LinkedHashMap<String,String> map = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\test\\employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            map = (LinkedHashMap<String, String>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Map.Entry entry : map.entrySet()){
            System.out.println("key = " + entry.getKey() + "value = " + entry.getValue());
        }
    }

}
