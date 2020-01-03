package com.zeng.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 10:12 上午
 **/
public class TokenBucketRateLimiter extends SimpleRateLimiter {
    private RateLimiter limiter;

    public TokenBucketRateLimiter(RateLimiterParam rateLimiterParam) {
        super(rateLimiterParam);
        this.limiter = RateLimiter.create(rateLimiterParam.getThreshold());
    }

    @Override
    public long acquire() {
        long start = System.currentTimeMillis();
        limiter.acquire();
        return TimeUnit.NANOSECONDS.toMicros(System.currentTimeMillis() - start);
    }

    @Override
    public boolean tryAcquire(long timeout, TimeUnit unit) {
        return limiter.tryAcquire(timeout, unit);
    }

    @Override
    public void supply() {

    }
}
