package com.ratelimiter.lee;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Driver {
    //https://leetcode.com/discuss/interview-question/object-oriented-design/1583096/API-Rate-limiter-or-LLD-(Common-Atlassian-question)/1153685
    ConcurrentMap<String, RateLimiter> userMap = new ConcurrentHashMap<>();
    public final static int TIME_SPAN = 5;
    public final static int ALLOWED_REQUEST = 25;

    public void sendRequest(String uid, String time) {
//        userMap.putIfAbsent(uid, new SlidingWindowRateLimiter(ALLOWED_REQUEST, TIME_SPAN));
//        boolean isAllowed = userMap.get(uid).isAllow(uid);

        userMap.putIfAbsent(uid, new FixedWindowRateLimiter(5, 1));
        if (userMap.get(uid).isAllow()) {
            System.out.println(uid + "---Allowed at " + time);
        } else {
            System.out.println(uid + "---Not Allowed " + time);
        }
    }
}
