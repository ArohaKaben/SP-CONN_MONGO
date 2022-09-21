package com.covdb.module.customer.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "customer")
public class CustomerDocument {

        @Id
        private int id;
        @NotNull
        private String firstName;
        @NotNull
        private String lastName;
        @NotNull
        private int age;
        @Email
        private String email;
}
