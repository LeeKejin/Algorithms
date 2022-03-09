package com.ratelimiter.lee;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {
    private int requestAllowed;
    private int timeSpan;

    public FixedWindowRateLimiter(int requestAllowed, int timeSpan) {
        this.requestAllowed = requestAllowed;
        this.timeSpan = timeSpan;
    }

    ConcurrentMap<Long, AtomicInteger> map = new ConcurrentHashMap<>();

    @Override
    public boolean isAllow() {
        long key = System.currentTimeMillis() / 1000 * 1000;
        map.putIfAbsent(key, new AtomicInteger(0));
        return map.get(key).incrementAndGet() <= getRate(requestAllowed, timeSpan);
    }
}
