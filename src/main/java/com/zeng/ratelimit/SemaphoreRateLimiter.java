package com.zeng.ratelimit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 10:12 上午
 **/
public class SemaphoreRateLimiter extends SimpleRateLimiter {
    private Semaphore semaphore;

    public SemaphoreRateLimiter(RateLimiterParam rateLimiterParam) {
        super(rateLimiterParam);
        this.semaphore = new Semaphore(rateLimiterParam.getThreshold());
    }

    @Override
    public long acquire() {
        try {
            long start = System.currentTimeMillis();
            semaphore.acquire();
            return TimeUnit.NANOSECONDS.toMicros(System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            throw new RateLimiterException("rate limiter is interrupted by others");
        }
    }

    @Override
    public boolean tryAcquire(long timeout, TimeUnit unit) {
        try {
            return semaphore.tryAcquire(timeout, unit);
        } catch (InterruptedException e) {
            throw new RateLimiterException("rate limiter is interrupted by others");
        }
    }


    @Override
    public void supply() {
        semaphore.release();
    }
}
