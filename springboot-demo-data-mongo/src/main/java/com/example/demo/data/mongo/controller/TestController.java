package com.example.demo.data.mongo.controller;

import com.example.demo.data.mongo.model.StreamData;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xg
 * @date 2022-03-30 16:07
 */
@RestController
public class TestController {

    @Resource
    private MongoTemplate mongoTemplate;

    @GetMapping("/data")
    public StreamData getData(String id) {
        StreamData streamData = mongoTemplate.findOne(generateQuery(id), StreamData.class);
        return streamData;
    }

    private Query generateQuery(String streamId) {
        Document queryObject = new Document();
        queryObject.put("_id", streamId);
        Document fieldsObject=new Document();
        fieldsObject.put("_id", 1);
        fieldsObject.put("channelId", 1);
        fieldsObject.put("streamGroup", 1);
        fieldsObject.put("prdMode", 1);
        fieldsObject.put("beginTime", 1);
        fieldsObject.put("endTime", 1);
//        fieldsObject.put("streamInfo", 1);
        fieldsObject.put("relayInfo", 1);
        fieldsObject.put("playbillMd5", 1);
        fieldsObject.put("updateType", 1);
        fieldsObject.put("updateTime", 1);
        Query query=new BasicQuery(queryObject,fieldsObject);
        return query;
    }

}
