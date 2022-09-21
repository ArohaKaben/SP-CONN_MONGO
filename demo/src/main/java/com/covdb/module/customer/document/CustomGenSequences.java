package com.covdb.module.customer.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customerseq")
public class CustomGenSequences {

    @Id
    String id;
    int seq;
}
