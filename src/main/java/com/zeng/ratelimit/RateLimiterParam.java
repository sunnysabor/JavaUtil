package com.zeng.ratelimit;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 9:53 上午
 **/
public class RateLimiterParam {
    private RateLimiterType rateLimiterType = RateLimiterType.TOKEN_BUCKET;

    private int threshold = 50;

    private long timeout = 3000;

    private TimeUnit unit = TimeUnit.MILLISECONDS;

    public int getThreshold() {
        return threshold;
    }

    public RateLimiterParam setThreshold(int threshold) {
        this.threshold = threshold;
        return this;
    }

    public long getTimeout() {
        return timeout;
    }

    public RateLimiterParam setTimeout(long timeout) {
        this.timeout = timeout;
        return this;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public RateLimiterParam setUnit(TimeUnit unit) {
        this.unit = unit;
        return this;
    }

    public RateLimiterType getRateLimiterType() {
        return rateLimiterType;
    }

    public void setRateLimiterType(RateLimiterType rateLimiterType) {
        this.rateLimiterType = rateLimiterType;
    }

    @Override
    public String toString() {
        return "RateLimiterParam{" +
                "rateLimiterType=" + rateLimiterType +
                ", threshold=" + threshold +
                ", timeout=" + timeout +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RateLimiterParam that = (RateLimiterParam) o;
        return threshold == that.threshold &&
                timeout == that.timeout &&
                rateLimiterType == that.rateLimiterType &&
                unit == that.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateLimiterType, threshold, timeout, unit);
    }
}
