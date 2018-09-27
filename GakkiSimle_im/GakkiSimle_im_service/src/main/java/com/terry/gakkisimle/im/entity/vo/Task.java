package com.terry.gakkisimle.im.entity.vo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class Task {
    public static Random random=new Random();
    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务1");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务1完成");
    }

    private long getEnd() {
        return System.currentTimeMillis();
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务2");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        System.out.println("完成任务2，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务2完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务3");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        System.out.println("完成任务3，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务3完成");
    }

}