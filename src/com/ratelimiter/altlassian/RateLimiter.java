package com.ratelimiter.altlassian;

public abstract class RateLimiter {

    final int requestsAllowed;
    final int timeAllowed;

    protected RateLimiter(int requestsAllowed, int timeAllowed) {
        this.requestsAllowed = requestsAllowed;
        this.timeAllowed = timeAllowed;
    }

    abstract boolean rateLimit();

}
