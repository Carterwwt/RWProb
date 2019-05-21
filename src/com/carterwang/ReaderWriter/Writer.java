package com.carterwang.ReaderWriter;

public class Writer extends Member {

    public Writer(int index, int startTime, int timeInterval) {
        super(index, startTime, timeInterval);
    }

    @Override
    public void print() {
        System.out.printf("W  ");
        super.print();
    }
}
