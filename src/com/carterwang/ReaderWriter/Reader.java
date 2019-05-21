package com.carterwang.ReaderWriter;

import com.carterwang.API.TimeAPI;
import com.carterwang.Sem.Sem;

public class Reader extends Member implements Runnable{

    public Reader(int index, int startTime, int timeInterval) {
        super(index, startTime, timeInterval);
    }

    @Override
    public void print() {
        System.out.printf("R  ");
        super.print();
    }

    @Override
    public synchronized void run() {
        try {
            read();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void read() throws InterruptedException {
        while(true) {
            if (TimeAPI.getCurrentTime() >= this.getStartTime()) {
                int currentTime = TimeAPI.getCurrentTime();
                int currentMin = currentTime / 60;
                int currentSec = currentTime % 60;
                if (!hasRequired) {
                    System.out.printf("Thread %d  R  [%02d:%02d]  Request\n", getIndex(), currentMin, currentSec);
                    hasRequired = true;
                }
                // increase readCount
                Sem.x.acquire();
                Sem.readCount++;
                if (Sem.readCount == 1) {
                    Sem.wsem.acquire();
                }
                Sem.x.release();
                currentTime = TimeAPI.getCurrentTime();
                currentMin = currentTime / 60;
                currentSec = currentTime % 60;
                System.out.printf("Thread %d  R  [%02d:%02d]  Start\n", getIndex(), currentMin, currentSec);
                Thread.sleep(1000 * getTimeInterval());
                currentTime = TimeAPI.getCurrentTime();
                currentMin = currentTime / 60;
                currentSec = currentTime % 60;
                System.out.printf("Thread %d  R  [%02d:%02d]  End\n", getIndex(), currentMin, currentSec);

                // decrease readCount
                Sem.x.acquire();
                Sem.readCount--;
                if (Sem.readCount == 0) {
                    Sem.wsem.release();
                }
                Sem.x.release();
                break;
            }
        }
    }


}
