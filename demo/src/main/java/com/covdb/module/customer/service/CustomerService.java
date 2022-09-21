package com.covdb.module.customer.service;


import com.covdb.module.customer.document.CustomerDocument;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDocument getName(String first);
    List<CustomerDocument> getNameByAgeLength(int ageSt,int ageEnd);

    int savaAllByMockupdate(List<CustomerDocument> dataSet);
}
