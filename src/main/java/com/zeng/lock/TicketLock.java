/**
 * Copyright (C), 2018, Jerry
 *
 * @ProjectName: JavaUtil
 * @Package: com.zeng.lock
 * @ClassName: TicketLock
 * @Author: jerry
 * @Date: 2018/8/21 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zeng.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jerry
 * @Description: 解决访问顺序的自旋锁(多核cpu)
 * @createDateTime 2019-01-23 14:38
 */
public class TicketLock {

    private AtomicInteger serviceNum = new AtomicInteger();
    private AtomicInteger ticketNum = new AtomicInteger();
    private static final ThreadLocal<Integer> local = new ThreadLocal<Integer>();

    public void lock() {
        int myticket = ticketNum.getAndIncrement();
        local.set(myticket);
        while (myticket != serviceNum.get()) {

        }
    }

    public void unlock() {
        int myticket = local.get();
        serviceNum.compareAndSet(myticket, myticket++);
    }
}
