package com.terry.gakkisimle.IM;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public void ImportNum() {
        List<Integer> numlist= Lists.newArrayListWithCapacity(2000);
        List<Integer> reslist= Lists.newArrayListWithCapacity(2000);
        int count=5000;
        for (int i = 0; i <50000 ; i++) {
            int finalI = i;
            MyThreadPool.threadPool.execute(() -> {
                numlist.add(finalI);
            });
        }
        MyThreadPool.threadPool.shutdown();
        while(true){
            if (count==0){
                break;
            }
        }
        System.out.println(numlist.size());
    }
}