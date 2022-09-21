package com.covdb.module.customer.bao;

import com.covdb.module.customer.document.CustomerDocument;
import com.covdb.module.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustComponent {

    @Autowired
    private CustomerService service;

    public ResponseEntity<?> get(List<CustomerDocument> dataSet ){
        int resultList =  service.savaAllByMockupdate(dataSet);
        System.out.println(resultList);
        if(resultList==0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resultList);
    }

    public ResponseEntity<?> getLengthage(int ageST,int ageEND){
        List<CustomerDocument> resultList =  service.getNameByAgeLength(ageST,ageEND);
//        System.out.println(resultList);
//        if(resultList==0){
//            return ResponseEntity.badRequest().build();
//        }
        return ResponseEntity.ok(resultList);
    }

}
