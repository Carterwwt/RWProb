package com.carterwang.Main;

import com.carterwang.FileService.FileAPI;
import com.carterwang.ReaderWriter.Member;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        String filename = "data.txt";
        List list = FileAPI.getListFromFile(filename);
        System.out.println("==========Loading data from file...===========");
        Thread.sleep(500);
        System.out.println(filename);
        System.out.println("===================Success====================");
        for(Object l: list) {
            System.out.printf("index: %d  ",list.indexOf(l));
            ((Member)l).print();
        }
    }

}
