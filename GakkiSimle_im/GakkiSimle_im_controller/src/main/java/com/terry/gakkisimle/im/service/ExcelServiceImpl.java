package com.terry.gakkisimle.im.service;

import com.google.common.collect.Lists;
import com.terry.gakkisimle.im.sys.MyThreadPool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public void ImportNum() throws InterruptedException {
        List<Integer> numlist= Lists.newArrayListWithCapacity(2000);
        List<Integer> reslist= Lists.newArrayListWithCapacity(2000);
        CountDownLatch countDownLatch=new CountDownLatch(50000);
        for (int i = 0; i <50000 ; i++) {
            int finalI = i;
            MyThreadPool.threadPool.execute(() -> {
                numlist.add(finalI);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(numlist.size());
    }
}