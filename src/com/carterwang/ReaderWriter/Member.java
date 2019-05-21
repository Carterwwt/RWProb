package com.carterwang.ReaderWriter;

public class Member {
    protected boolean hasRequired = false;

    private int index;
    private int startTime;
    private int timeInterval;

    public Member(int index, int startTime, int timeInterval) {
        this.index = index;
        this.startTime = startTime;
        this.timeInterval = timeInterval;
    }

    public int getIndex() {
        return index;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getTimeInterval() {
        return timeInterval;
    }


    public void print() {
        System.out.printf("     %d        %2d           %2d\n",getIndex(),getStartTime(),getTimeInterval());
    }

}
