package com.ratelimiter.altlassian;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH.mm.ss.SSS aa");
        Driver sendRequest = new Driver();

		/*
		This was to test the sliding window ->
		Made sure that bursts of requests would come near the boundary
		Something like this ->  |R......RRR|.RRRR.......|
		*/
//        sendRequest.checkRequestAllowed("user1", formatter.format(new Date()));
//        Thread.sleep(996);
//        System.out.println("Sleep");

        for (int i = 0; i < 14; i++) {
            if (i == 5) {
                Thread.sleep(1000);
                System.out.println("Sleep 100");

            }
            sendRequest.checkRequestAllowed("user1", formatter.format(new Date()));
        }


//        Thread.sleep(1700);
//        System.out.println("Sleep 1700");
//
//        for (int i = 0; i < 15; i++) {
//            sendRequest.checkRequestAllowed("user1", formatter.format(new Date()));
//        }


//        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        Thread t1 = new Thread(new Runnable() {
//
//            public void run() {
//                for (int i = 0; i < 12; i++) {
//                    String curTime1 = formatter.format(new Date());
//                    sendRequest.checkRequestAllowed("u1", curTime1);
//                }
//            }
//        });


//        Thread t2 = new Thread(new Runnable() {
//
//            public void run() {
//                for (int i = 0; i < 14; i++) {
//                    String curTime1 = formatter.format(new Date());
//                    sendRequest.checkRequestAllowed("u2", curTime1);
//                }
//            }
//        });
//        t1.start();
//        t2.start();

//        t1.join();
//        t2.join();


//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        for (int i = 0; i < 25; i++) {
//
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    String curTime1 = formatter.format(new Date());
//                    sendRequest.checkRequestAllowed("u1", curTime1);
//                }
//            });
//        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

