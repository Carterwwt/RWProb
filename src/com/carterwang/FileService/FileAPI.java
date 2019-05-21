package com.carterwang.FileService;

import com.carterwang.Model.ThreadData;
import com.carterwang.ReaderWriter.Member;
import com.carterwang.ReaderWriter.Reader;
import com.carterwang.ReaderWriter.Writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAPI {

    public static List getListFromFile(String filename) {
        List list = new ArrayList<>();
        File file = new File(filename);
        if(!file.exists()) {
            System.out.println("File not existed!");
            return null;
        }
        try {
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            String line;
            while((line = reader.readLine()) != null) {
                Member member = getDataFromLine(line);
                list.add(member);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return list;
    }

    private static Member getDataFromLine(String line) {
        String[] result = line.split("\\s+");
        switch (result[1]) {
            case "R":
                return new Reader(Integer.parseInt(result[0]),Integer.parseInt(result[2]),Integer.parseInt(result[3]));
            case "W":
                return new Writer(Integer.parseInt(result[0]),Integer.parseInt(result[2]),Integer.parseInt(result[3]));
            default:
                return null;
        }
    }

}
