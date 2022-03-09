package com.ratelimiter.altlassian;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Driver {

    private ConcurrentMap<String, RateLimiter> clientMap = new ConcurrentHashMap<>();
//    private Map<String, RateLimiter> clientMap = new HashMap<>();

    final int MAX_REQ = 10;
    final int TIME = 1;

    //synchronized
    void checkRequestAllowed(String uid, String time) {
        if (!clientMap.containsKey(uid)) {
            RateLimiter rateLimiter = new SlidingWindowRateLimiter(MAX_REQ, TIME);
            clientMap.put(uid, rateLimiter);
        }

        if (clientMap.get(uid).rateLimit()) {
            System.out.println(uid + " " + time + " ALLOWED");
        } else {
            System.out.println(uid + " " + time + " NOT ALLOWED");
        }
    }
}
