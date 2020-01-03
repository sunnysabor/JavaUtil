package com.zeng.ratelimit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 10:38 上午
 **/
public class RateLimiterException extends RuntimeException {
    public RateLimiterException(String message) {
        super(message);
    }

    public RateLimiterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateLimiterException(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
