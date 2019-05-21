package com.carterwang.API;

import java.util.Date;

public class TimeAPI {
    private static Date startTimeStamp;

    public static void initialTime() {
        startTimeStamp = new Date();
    }

    public static int getCurrentTime() {
        Date now = new Date();
        return Math.toIntExact((now.getTime() - startTimeStamp.getTime()) / 1000);
    }


}
