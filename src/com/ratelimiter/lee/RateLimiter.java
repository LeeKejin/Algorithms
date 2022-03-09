package com.ratelimiter.lee;

public interface RateLimiter {
    boolean isAllow();

    default double getRate(int requestAllowed, int timeSpan) {
        return requestAllowed / (timeSpan * 1.0);
    }
}
