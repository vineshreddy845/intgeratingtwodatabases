package com.example.integerationwithtwodatabases.modelnonsql;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
@Data
@Document(collection ="reddy")
public class modelnonsql {

    private String names;
    private String last;
    private int age;
    private String email;
}
