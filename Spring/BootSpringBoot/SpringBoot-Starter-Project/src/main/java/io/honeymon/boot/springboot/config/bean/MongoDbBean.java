package io.honeymon.boot.springboot.config.bean;

import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

//@Component
public class MongoDbBean {
    private final MongoDbFactory mongoDbFactory;

    @Autowired
    public MongoDbBean(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
    }

//    public void getDb() {
//        DB db = mongoDbFactory.getDb();
//    }
}
