package com.example.integerationwithtwodatabases.contoller;

import com.example.integerationwithtwodatabases.modelnonsql.modelnonsql;
import com.example.integerationwithtwodatabases.modelsql.modelsql;
import com.example.integerationwithtwodatabases.repositortnonsql.repositortnonsql;
import com.example.integerationwithtwodatabases.repository.repositorysql;
import com.example.integerationwithtwodatabases.response.Response;
import com.example.integerationwithtwodatabases.serverice.serverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/map")
public class controller {

    @Autowired
    private repositorysql sqll;
    @Autowired
    private repositortnonsql sql;
    @Autowired
    private serverice ser;
    @Autowired
    private Response respone;

    @GetMapping("/sql")
    public List<modelsql> sql() {
        return sqll.findAll();
    }

    @GetMapping("/nonsql")
    public List<modelnonsql> nonsql() {
        return sql.findAll();

    }

    //http://localhost:8082/map/add
    //below adding in to mysql database.
    @PostMapping("/add")
    public modelsql add(@RequestBody modelsql sql) {
        return sqll.save(sql);
    }

    @PostMapping("/addnonsql")
    public modelnonsql nonsql(@RequestBody modelnonsql sqlq) {
        return sql.save(sqlq);
    }




    //http://localhost:8082/map/condition/vinesh
    @GetMapping("/condition/{names}")
    public List<modelsql> sqlq(modelsql sqlll, @PathVariable(value = "names") String names) {


        return sqll.findByname(names);
       // return null;
    }

    @GetMapping("/checks")
  public List<Response> checks(@RequestBody modelsql sql)
  {
      String name1=sql.getName();
      int student=sql.getStudentid();

      boolean d= ser.isvalid(name1,student);
     List<Response>res = new ArrayList<>();
      respone.setFirst(d);
      res.add(respone);
      return res;
      //note response wrong. you have to write correct query. do it tommorrow.
  }







}
