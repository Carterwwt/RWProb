package com.carterwang.ReaderWriter;

import com.carterwang.API.TimeAPI;
import com.carterwang.Sem.Sem;

public class Writer extends Member implements Runnable {

    public Writer(int index, int startTime, int timeInterval) {
        super(index, startTime, timeInterval);
    }

    @Override
    public void print() {
        System.out.printf("W  ");
        super.print();
    }

    @Override
    public synchronized void run() {
        try {
            write();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void write() throws InterruptedException {
        while(true) {
            if (TimeAPI.getCurrentTime() >= this.getStartTime()) {
                int currentTime = TimeAPI.getCurrentTime();
                int currentMin = currentTime / 60;
                int currentSec = currentTime % 60;
                if (!hasRequired) {
                    System.out.printf("Thread %d  W  [%02d:%02d]  Request\n", getIndex(), currentMin, currentSec);
                    hasRequired = true;
                }
                // request for write
                Sem.wsem.acquire();
                currentTime = TimeAPI.getCurrentTime();
                currentMin = currentTime / 60;
                currentSec = currentTime % 60;
                System.out.printf("Thread %d  W  [%02d:%02d]  Start\n", getIndex(), currentMin, currentSec);
                Thread.sleep(1000 * getTimeInterval());
                currentTime = TimeAPI.getCurrentTime();
                currentMin = currentTime / 60;
                currentSec = currentTime % 60;
                System.out.printf("Thread %d  W  [%02d:%02d]  End\n", getIndex(), currentMin, currentSec);
                Sem.wsem.release();
                break;
            }
        }
    }
}
