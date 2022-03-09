package com.ratelimiter.lee;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiter implements RateLimiter {
    private final ConcurrentMap<Long, AtomicInteger> map = new ConcurrentHashMap<>();

    private int requestAllowed;
    private int timeSpan;

    public SlidingWindowRateLimiter(int requestAllowed, int timeSpan) {
        this.requestAllowed = requestAllowed;
        this.timeSpan = timeSpan;
    }

    @Override
    public boolean isAllow() {
        long curTime = System.currentTimeMillis();
        long curKey = curTime / 1000;
        map.putIfAbsent(curKey, new AtomicInteger(0));
        long prevKey = curKey - 1000 * timeSpan;
        if (!map.containsKey(prevKey)) {
            return map.get(curKey).incrementAndGet() <= getRate(requestAllowed, timeSpan);
        }
        double p = 1 - (curTime - curKey) / 1000;

        return (p * map.get(prevKey).get() + map.get(curKey).incrementAndGet()) <= getRate(requestAllowed, timeSpan);


//        Long curTime = System.currentTimeMillis();
//        Long curKey = curTime / 1000 * 1000;
//        map.putIfAbsent(curKey, new AtomicInteger(0));
//        long prevKey = curKey - 1000;
//        if (!map.containsKey(prevKey)) {
//            return map.get(curKey).incrementAndGet() <= requestAllowed / timeSpan;
//        }
//
//        double previousReqPrecentage = 1 - (curTime - curKey) / 1000.0;
//        return (previousReqPrecentage * map.get(prevKey).get() + map.get(curKey).incrementAndGet()) <= requestAllowed / timeSpan;
    }
}

