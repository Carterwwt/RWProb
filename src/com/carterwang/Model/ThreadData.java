package com.carterwang.Model;

public class ThreadData {
    private int id;
    private int startTime;
    private int timeInterval;

    public String getId() {
        switch (id) {
            case -1:
                return "R";
            case -2:
                return "W";
            default:
                return "Unknown";
        }
    }

    public int getStartTime() {
        return startTime;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public ThreadData(int id, int startTime, int timeInterval) {
        this.id = id;
        this.startTime = startTime;
        this.timeInterval = timeInterval;
    }

    @Override
    public String toString() {
        return String.format("id: %s  startTime: %d(secs)  lastThrough: %d(secs)",getId(),startTime, timeInterval);
    }
}
