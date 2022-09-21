package com.covdb.module.customer.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class GetAgeLength {

    @NotNull
    private int ageStart;
    private int ageEnd;
}
