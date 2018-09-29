package com.terry.gakkisimle.im.sys.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
@Slf4j
public class Task {
    public static Random random=new Random();
    public static Log log = LogFactory.getLog(Task.class);
    @Async("taskExecutor")
    public Future<String> doTaskOne() throws Exception {
        log.info("开始做任务1");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        log.info("完成任务2，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务1完成");
    }

    private long getEnd() {
        return System.currentTimeMillis();
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        log.info("开始做任务2");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        log.info("完成任务2，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务2完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskThree() throws Exception {
        log.info("开始做任务3");
        long start = getEnd();
        Thread.sleep(random.nextInt(10000));
        long end = getEnd();
        log.info("完成任务3，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务3完成");
    }

}