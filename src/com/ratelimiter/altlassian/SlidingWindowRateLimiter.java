package com.ratelimiter.altlassian;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowRateLimiter extends RateLimiter {

    private final ConcurrentMap<Long, AtomicInteger> window = new ConcurrentHashMap<>();


    protected SlidingWindowRateLimiter(int requests, int time) {
        super(requests, time);
    }

    @Override
    boolean rateLimit() {
        long curTime = System.currentTimeMillis();
        long curwkey = curTime / 1000 * 1000;

        window.putIfAbsent(curwkey, new AtomicInteger(0));
        long previousWkey = curwkey - 1000;
        AtomicInteger preCount = window.get(previousWkey);

        if (preCount == null)
            return window.get(curwkey).incrementAndGet() <= (requestsAllowed / timeAllowed);
//1:total time %, curwkey 在一秒内都不变，curTime - curwkey-> 当前timewindow中所占比例， previouswt是有同一curwkey的request的所占比例

        double previouswt = 1 - (curTime - curwkey) / 1000.0;

        long count = (long) (preCount.get() * previouswt + window.get(curwkey).incrementAndGet());
        System.out.println(curTime + "----key:" + curwkey + "---prev:" + previouswt + "-----" + preCount.get() * previouswt + "---------" + count);

        return count <= (requestsAllowed / timeAllowed);
    }
}
