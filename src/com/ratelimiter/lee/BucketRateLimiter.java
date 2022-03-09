package com.ratelimiter.lee;

public class BucketRateLimiter implements RateLimiter {

    private long refillRate;
    private long maxSize;
    private long currentSize;
    private long lastRefillTime;

    public BucketRateLimiter(long refillRate, long maxSize) {
        this.refillRate = refillRate;
        this.maxSize = maxSize;
        this.currentSize = maxSize;
//        this.lastRefillTime = System.nanoTime();
        this.lastRefillTime = System.currentTimeMillis();
    }

    private void refill() {
        long currentTime = System.currentTimeMillis();
        //if this.lastRefillTime = System.currentTimeMillis(); and long currentTime = System.currentTimeMillis();
        long tokenToAdd = (currentTime - lastRefillTime) * refillRate / 1000;
//        long tokenToAdd = (currentTime - lastRefillTime) * refillRate / (long) 1e9;
        System.out.println(tokenToAdd + "---------");
        currentSize = Math.min(maxSize, currentSize + tokenToAdd);
        lastRefillTime = currentTime;
    }

    public synchronized boolean isAllow() {
        int tokens = 1;
        refill();
        if (currentSize >= tokens) {
            currentSize -= tokens;
            return true;
        }
        return false;
    }
}

