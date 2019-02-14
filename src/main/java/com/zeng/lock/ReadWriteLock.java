/**
 * Copyright (C), 2018, Jerry
 *
 * @ProjectName: JavaUtil
 * @Package: com.zeng.lock
 * @ClassName: ReadWriteLock
 * @Author: jerry
 * @Date: 2018/8/21 13:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zeng.lock;

/**
 * @Description:读写锁
 * @author jerry
 * @createDateTime 2019-02-14 10:47
 */
public class ReadWriteLock {

    private int readers=0;
    private int writers=0;
    private int writeRequest=0;


    public synchronized void lockRead() throws InterruptedException {
        while(writeRequest>0||writeRequest>0){
            this.wait();
        }
        readers++;
    }

    public synchronized void unlockRead(){
        readers--;
        this.notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        writeRequest++;

        while(writers>0||readers>0){
            this.wait();
        }

        writeRequest--;
        writers++;
    }

    public synchronized  void unlockWrite(){
        writers--;
        notifyAll();
    }
}
