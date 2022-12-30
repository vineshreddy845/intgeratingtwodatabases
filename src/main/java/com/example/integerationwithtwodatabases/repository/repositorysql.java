package com.example.integerationwithtwodatabases.repository;

import com.example.integerationwithtwodatabases.modelsql.modelsql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repositorysql extends JpaRepository<modelsql,Long> {
  //@Query("select count(name) from modelsql where name=?1")
    @Query("select count(*) from modelsql where name=:name and studentid=:student")
    long getcount(String name,int student);
    // we know the protcol findbyvariablename(same should in model class)(datatype variablename);
    //but we can also create different way. if you click on jpaRepository.
    //It goes to extended class.then click on curdrepository. there we have methods.
    //1.long count(). etc. baised on that we should define method.
//****//SELECT count(*) from tablename where name=:name and studentid=:student;//excute in sqlbench for verfication.
    // for one paremeter use these.SELECT count(coloumname) from tablename where name=:name;
    // above first query remember "and" condition you know that.

  // @Query("from modelsql where name=?1")// data is coming from user. So that we place ?1. we place 1 because we can have multiple data coming from user.
   @Query("from modelsql where name =:name")
   public List<modelsql> findByname(String name);

}
