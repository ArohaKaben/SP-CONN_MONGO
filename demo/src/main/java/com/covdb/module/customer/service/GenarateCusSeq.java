package com.covdb.module.customer.service;

import com.covdb.module.customer.document.CustomGenSequences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class GenarateCusSeq {

    @Autowired
    private MongoOperations operations;

    public int getNextSequence(String seqName) {
        CustomGenSequences gen = operations.findAndModify(
                query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                CustomGenSequences.class);
        return gen.getSeq();
    }
}
