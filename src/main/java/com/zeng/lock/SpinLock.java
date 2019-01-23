/**
 * Copyright (C), 2018, Jerry
 * 由于自旋锁只是将当前线程不停地执行循环体，不进行线程状态的改变，所以响应速度更快。
 * 但当线程数不停增加时，性能下降明显，因为每个线程都需要执行，占用CPU时间。
 * 如果线程竞争不激烈，并且保持锁的时间段。适合使用自旋锁。
 * @ProjectName: JavaUtil
 * @Package: com.zeng.lock
 * @ClassName: SpinLock
 * @Author: jerry
 * @Date: 2018/8/21 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zeng.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:自旋锁
 * @author jerry
 * @createDateTime 2019-01-23 14:22
 */
public class SpinLock {

    private AtomicReference<Thread> sign=new AtomicReference<Thread>();

    public void lock(){
        Thread current=Thread.currentThread();
        while(!sign.compareAndSet(null,current)){

            /**
             * 当有第二个线程调用lock操作时由于owner值不为空，导致循环一直被执行，
             * 直至第一个线程调用unlock函数将owner设置为null，第二个线程才能走出循环。
             */

        }
    }

    public void unlock(){
        Thread current=Thread.currentThread();
        sign.compareAndSet(current,null);
    }
}
