package com.example.integerationwithtwodatabases.serverice;

import com.example.integerationwithtwodatabases.repository.repositorysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serverice {
    @Autowired
    private repositorysql repo;
    public boolean isvalid(String name1, int student) {

        long a=repo.getcount(name1,student);
        boolean b= a!=0;
       return b;
    }
}
