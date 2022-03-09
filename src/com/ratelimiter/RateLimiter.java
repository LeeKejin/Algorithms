package com.ratelimiter;

public interface RateLimiter {

    boolean check(String eid);
}
