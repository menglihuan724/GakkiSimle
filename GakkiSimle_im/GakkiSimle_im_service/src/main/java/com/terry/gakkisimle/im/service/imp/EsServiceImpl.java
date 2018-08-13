package com.terry.gakkisimle.im.service.imp;

import com.terry.gakkisimle.im.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Author:TERRY_MENG
 * @Date:2018-08-13
 */
@Service
public class EsServiceImpl implements EsService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Override
    public Map queryAllIndices() {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(matchAllQuery())
//                .withIndices("zipkin")
//                //.withPageable(new PageRequest(0,1))
//                .build();
        return elasticsearchTemplate.getSetting("zipkin");
    }
}
