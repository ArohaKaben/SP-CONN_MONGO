package com.covdb.module.customer.service.impl;

import com.covdb.module.customer.document.CustomerDocument;
import com.covdb.module.customer.repository.CustomerRepository;
import com.covdb.module.customer.service.CustomerService;
import com.covdb.module.customer.service.GenarateCusSeq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    public CustomerRepository repo;
    @Autowired
    public GenarateCusSeq genSeq;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public CustomerDocument getName(String first) {
        return null;
    }

    @Override
    public List<CustomerDocument> getNameByAgeLength(int ageSt, int ageEnd) {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(ageSt).and("age").lte(ageEnd));
        List<CustomerDocument> cusList = repo.findByAgeBetween(ageSt,ageEnd);
        return cusList;
    }

    @Override
    public int savaAllByMockupdate(List<CustomerDocument> dataSet) {
        for(int i =0;i<dataSet.size();i++){
            dataSet.get(i).setId(genSeq.getNextSequence("customerseq"));
        }
        List<CustomerDocument> data = repo.saveAll(dataSet);
//        CustomerDocument data = repo.save(dataSet.get(0));
        if(data.size()>1){
            return data.size();
        }
        return 0;
    }


}
