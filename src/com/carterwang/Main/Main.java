package com.carterwang.Main;

import com.carterwang.API.FileAPI;
import com.carterwang.API.TimeAPI;
import com.carterwang.ReaderWriter.Member;
import com.carterwang.ReaderWriter.Reader;
import com.carterwang.ReaderWriter.Writer;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String filename = "data.txt";
        List list = FileAPI.getListFromFile(filename);
        System.out.println("==========Loading data from file...===========");
        Thread.sleep(500);
        System.out.println(filename);
        System.out.println("===================Success====================");
        System.out.println("R/W   Index   StartTime   TimeInterval");
        for(Object o: list) {
            ((Member)o).print();
        }
        System.out.println("===============Read/Write Start===============");
        TimeAPI.initialTime();
        for(Object o: list) {
            if(o instanceof Reader) {
                new Thread((Reader)o).start();
            }
            if(o instanceof Writer) {
                new Thread((Writer)o).start();
            }
        }
    }

}
