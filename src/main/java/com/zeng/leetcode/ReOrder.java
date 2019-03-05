/**
 * Copyright (C), 2018, Jerry
 *
 * @ProjectName: JavaUtil
 * @Package: com.zeng.leetcode
 * @ClassName: ReOrder
 * @Author: jerry
 * @Date: 2018/8/21 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zeng.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 指令重排序问题
 *
 * 1.编译器优化：对于没有数据依赖关系的操作，编译器在编译的过程中会进行一定程度的重排
 * 2.指令重排序：CPU 优化行为，也是会对不存在数据依赖关系的指令进行一定程度的重排。和编译器优化差不多，
 * 就算编译器不发生重排，CPU 也可以对指令进行重排
 * 3.内存系统重排序：内存系统没有重排序，但是由于有缓存的存在，使得程序整体上会表现出乱序的行为。
 * 假设不发生编译器重排和指令重排，线程 1 修改了 a 的值，但是修改以后，a 的值可能还没有写回到主存中，那么线程 2 得到 a == 0 就是很自然的事了。
 * 同理，线程 2 对于 b 的赋值操作也可能没有及时刷新到主存中。
 *
 *
 * 现代多核 CPU 中每个核心拥有自己的一级缓存或一级缓存加上二级缓存等，问题就发生在每个核心的独占缓存上。
 * 每个核心都会将自己需要的数据读到独占缓存中，数据修改后也是写入到缓存中，然后等待刷入到主存中。
 * 所以会导致有些核心读取的值是一个过期的值。
 * @author jerry
 * @createDateTime 2019-03-05 13:10
 */
public class ReOrder {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException{
        int i = 0;
        for(;;) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            latch.countDown();
            one.join();
            other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}
