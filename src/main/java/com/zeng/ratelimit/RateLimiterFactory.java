package com.zeng.ratelimit;

/**
 * @Description:限流器工厂
 * @Author jerry
 * Date 2020/1/3 9:52 上午
 **/
public class RateLimiterFactory {

    public static SimpleRateLimiter getSimpleRateLimiter(RateLimiterParam rateLimiterParam) {
        if (RateLimiterType.SEMAPHORE.equals(rateLimiterParam.getRateLimiterType())) {
            return new SemaphoreRateLimiter(rateLimiterParam);
        } else {
            return new TokenBucketRateLimiter(rateLimiterParam);
        }
    }
}
