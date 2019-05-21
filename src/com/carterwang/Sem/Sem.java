package com.carterwang.Sem;

import java.util.concurrent.Semaphore;

public class Sem {
    public static Semaphore x = new Semaphore(1);
    public static Semaphore wsem = new Semaphore(1);
    public static int readCount = 0;
}
