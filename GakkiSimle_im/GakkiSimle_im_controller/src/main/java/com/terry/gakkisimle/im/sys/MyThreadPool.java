package com.terry.gakkisimle.im.sys;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-07-16
 */
public class MyThreadPool {
    public static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(15, 20, 3,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(7000),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) {
        for (int i = 0; i <50000 ; i++) {
           final int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            });
        }
    }
}
