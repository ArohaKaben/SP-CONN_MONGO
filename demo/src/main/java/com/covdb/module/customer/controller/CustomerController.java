package com.covdb.module.customer.controller;

import com.covdb.module.customer.bao.CustComponent;
import com.covdb.module.customer.document.CustomerDocument;
import com.covdb.module.customer.request.GetAgeLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    public CustComponent cus;


    @PostMapping("/save_mockup")
    public @ResponseBody ResponseEntity<?> setDataMockUp(@RequestBody List<CustomerDocument> mockSet){
        return cus.get(mockSet);
    }

    @PostMapping("/getagelength")
    public @ResponseBody ResponseEntity<?> getLengthAge(@RequestBody GetAgeLength dataSet){
        return  cus.getLengthage(dataSet.getAgeStart(),dataSet.getAgeEnd());
    }

    @PostMapping("/getName")
    public @ResponseBody ResponseEntity<?> getName(@RequestBody String name){
        return "test";
    }
}
