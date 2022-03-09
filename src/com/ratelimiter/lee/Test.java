package com.ratelimiter.lee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:sss");
        Driver driver = new Driver();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i == 0) {
                        try {
                            Thread.sleep(995);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    driver.sendRequest("user1", formatter.format(new Date()));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (i == 5) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    driver.sendRequest("user2", formatter.format(new Date()));
                }
            }
        });


        t1.start();
        t2.start();


        t1.join();
        t2.join();
    }
}
