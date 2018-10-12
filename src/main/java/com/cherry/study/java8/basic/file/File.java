package com.cherry.study.java8.basic.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

    public static String processFile()throws IOException{

        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        return br.readLine();
    }

}
