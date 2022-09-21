package com.covdb.module.customer.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;

@Data
public class CusAddress {

    @Id
    private String idAddress;
    private String city;
    private String country;
}
