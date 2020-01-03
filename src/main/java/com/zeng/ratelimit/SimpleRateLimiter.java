package com.zeng.ratelimit;


import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 9:53 上午
 **/
public abstract class SimpleRateLimiter {

    protected static final Logger log = LoggerFactory.getLogger(SimpleRateLimiter.class);

    protected RateLimiterParam rateLimiterParam = new RateLimiterParam();

    public SimpleRateLimiter(RateLimiterParam rateLimiterParam) {
        Preconditions.checkNotNull(rateLimiterParam, "限流参数不能为空!");
        setRateLimiterParam(rateLimiterParam);
    }

    public RateLimiterParam getRateLimiterParam() {
        return rateLimiterParam;
    }

    private void setRateLimiterParam(RateLimiterParam rateLimiterParam) {
        if (rateLimiterParam.getThreshold() < 0) {
            log.warn("ratelimiter threshold set to " + rateLimiterParam.getThreshold() + ", is less than zero, will have no effect.");
        } else {
            this.rateLimiterParam.setThreshold(rateLimiterParam.getThreshold());
        }
        if (rateLimiterParam.getTimeout() < 0) {
            log.warn("ratelimiter timeout set to " + rateLimiterParam.getThreshold() + ", is less than zero, will have no effect.");
        } else {
            this.rateLimiterParam.setTimeout(rateLimiterParam.getTimeout());
        }
        if (Objects.isNull(rateLimiterParam.getUnit())) {
            log.warn("ratelimiter timeUnit is null, will have no effect.");
        } else {
            this.rateLimiterParam.setUnit(rateLimiterParam.getUnit());
        }
        this.rateLimiterParam.setRateLimiterType(rateLimiterParam.getRateLimiterType());
    }


    public abstract long acquire();

    public boolean tryDefaultAcquire() {
        return tryAcquire(rateLimiterParam.getTimeout(), rateLimiterParam.getUnit());
    }

    public abstract boolean tryAcquire(long timeout, TimeUnit unit);


    public abstract void supply();

}
