package com.zeng.ratelimit;

/**
 * @Description:
 * @Author jerry
 * Date 2020/1/3 10:01 上午
 **/
public enum RateLimiterType {
    SEMAPHORE(1, "并发限流"),

    TOKEN_BUCKET(2, "令牌桶限流");


    private int code;

    private String desc;


    RateLimiterType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
