package com.covdb.module.customer.repository;


import com.covdb.module.customer.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepository extends MongoRepository<CustomerDocument,String> {
    CustomerDocument findByFirstName(String firstName);
    @Query("{'age': {$gte: ?0, $lte:?1 }}")
    List<CustomerDocument> findByAgeBetween(int ageSt, int ageEnd);
}
