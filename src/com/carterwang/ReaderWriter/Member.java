package com.carterwang.ReaderWriter;

public class Member {
    private int index;
    private int startTime;
    private int timeInterval;

    public Member(int index, int startTime, int timeInterval) {
        this.index = index;
        this.startTime = startTime;
        this.timeInterval = timeInterval;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void print() {
        System.out.printf("startTime: %d  timeInterval: %d\n",getStartTime(),getTimeInterval());
    }

}
