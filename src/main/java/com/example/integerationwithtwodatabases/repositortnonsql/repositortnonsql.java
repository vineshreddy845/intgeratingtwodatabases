package com.example.integerationwithtwodatabases.repositortnonsql;

import com.example.integerationwithtwodatabases.modelnonsql.modelnonsql;
import com.example.integerationwithtwodatabases.modelsql.modelsql;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repositortnonsql extends MongoRepository<modelnonsql,String> {
    //public List<modelnonsql> findByname(String name);

   // public List<modelnonsql> findBylast(String last);

}
