package com.covdb.module.customer.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoDBConfig {
/**
* Use for delete Field "_class"
**/
//    @Autowired
//    private MongoClient mongoClient;
//
//    @Value("${spring.data.mongodb.database}")
//    private String dbName;
//
//
//    public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
//        ReactiveMongoTemplate template = new ReactiveMongoTemplate( mongoClient, dbName);
//        MappingMongoConverter converter = (MappingMongoConverter) template.getConverter();
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        converter.afterPropertiesSet();
//        return template;
//    }

    @Autowired
    MongoDatabaseFactory mongoDbFactory;
    @Autowired
    MongoMappingContext mongoMappingContext;

    @Bean
    public MappingMongoConverter mappingMongoConverter() {

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return converter;
    }


}
