package com.carterwang.ReaderWriter;

public class Reader extends Member {

    public Reader(int index, int startTime, int timeInterval) {
        super(index, startTime, timeInterval);
    }

    @Override
    public void print() {
        System.out.printf("R  ");
        super.print();
    }
}
