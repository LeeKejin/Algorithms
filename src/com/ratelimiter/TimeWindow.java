package com.ratelimiter;

import java.util.concurrent.TimeUnit;

public class TimeWindow {
    int no;
    TimeUnit timeUnit;

    public TimeWindow(int no, TimeUnit timeUnit) {
        this.no = no;
        this.timeUnit = timeUnit;
    }
}
