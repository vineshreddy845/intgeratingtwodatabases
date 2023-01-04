package com.example.integerationwithtwodatabases.contoller;

import com.example.integerationwithtwodatabases.modelnonsql.modelnonsql;
import com.example.integerationwithtwodatabases.modelsql.modelsql;
import com.example.integerationwithtwodatabases.repositortnonsql.repositortnonsql;
import com.example.integerationwithtwodatabases.repository.repositorysql;
import com.example.integerationwithtwodatabases.response.Response;
import com.example.integerationwithtwodatabases.serverice.serverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")

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
    @Autowired
    private MongoTemplate mongoTemplate; //in built-class.comes from mongorepository.

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
    public modelnonsql nonsqlr(@RequestBody modelnonsql sqlqr) {
        //return sql.save(sqlqr);
        return null;
    }
   /* @GetMapping("/get")
    public List<modelnonsql> nonsqlf() {
        return sql.findByname("excellent");
    }*/




    //http://localhost:8082/map/condition/vinesh
    @GetMapping("/condition/{names}")
    public List<modelsql> sqlq(modelsql sqlll, @PathVariable(value = "names") String names) {


        return sqll.findByname(names);
       // return null;
    }

    // here we are passing two values and checking present in sql database.
    // if it is true then . it will fetch data from mongodb.
    //response in stored in response class.
    @GetMapping("/checks")
  public Response checks(@RequestBody modelsql sqlr, modelnonsql nonsql) {
        String name1 = sqlr.getName();
        int student = sqlr.getStudentid();

        boolean d = ser.isvalid(name1, student);
        respone.setStore(d);
        respone.setDescribe("response is working");

       // List<modelnonsql> q = null; // here we stored response in the List<modelnonsql> see below.
        if (d == true) {
            respone.setQ(sql.findByname(name1));
        }
        return respone;


    }

    //here above code reterive mongo-query in defining repository class.
    //below there is another way mongo-query defining see below.
    //see 103,104,105 line.mongoTemplate. mongoTemplate object is declared above.
   @GetMapping("/newway")
    public Response modelnonsqlq(@RequestBody modelsql sg)
    {
        String name1 = sg.getName();
        int student = sg.getStudentid();

        boolean d = ser.isvalid(name1, student);
        respone.setStore(d);
        respone.setDescribe("response is working");
        if(d=true){
            Query query = new Query();
          query.addCriteria(Criteria.where("name").is(name1));
        respone.setQ( mongoTemplate.find(query,modelnonsql.class));
        }
        return respone;
    }

    // using AND,OR operators in mongodb.

    @GetMapping("/oroperator")
    public Response c(@RequestBody modelsql sq, modelnonsql sls){
        String name1 = sq.getName();
        int student = sq.getStudentid();
        boolean d = ser.isvalid(name1, student);
        respone.setStore(d);
        respone.setDescribe("i used $or operator for mongodb query.To retive data. see in code.");
        if(d=true){
            Query query = new Query();
            Criteria criteria = new Criteria();
            criteria.orOperator(Criteria.where("name").is(name1),Criteria.where("age").is(student));
            query.addCriteria(criteria);
            respone.setQ(mongoTemplate.find(query,modelnonsql.class));
        }
       return respone;
    }
    @GetMapping("/andoperator")
    public Response qt(@RequestBody modelsql lo, modelnonsql nonsql){

        String name1=lo.getName();
        int student = lo.getStudentid();
      boolean d = ser.isvalid(name1, student);
      respone.setStore(d);
      respone.setDescribe("i used $and operator for mongodb query.To retive data. see in code.");
      if(d=true){
          Query query = new Query();
          Criteria criteria = new Criteria();
          criteria.andOperator(Criteria.where("name").is(name1),Criteria.where("age").is(student));
          query.addCriteria(criteria);
          respone.setQ(mongoTemplate.find(query,modelnonsql.class));
      }
      return respone;

  }

  @GetMapping("/gohead")
  public List<modelsql>sd(@RequestBody modelsql wear)
  {
      String name1= wear.getName();
      return sqll.findByname(name1);
  }

  @GetMapping("/path/{name}/{studentid}")
  public Response fg(@PathVariable("name") String name,@PathVariable("studentid") int studentid){
        String name1 = name;
        int student = studentid;
      boolean d = ser.isvalid(name1, student);
      respone.setStore(d);
      respone.setDescribe("i used $and operator for mongodb query.To retive data. see in code.");
      if(d=true){
          Query query = new Query();
          Criteria criteria = new Criteria();
          criteria.andOperator(Criteria.where("name").is(name1),Criteria.where("age").is(student));
          query.addCriteria(criteria);
          respone.setQ(mongoTemplate.find(query,modelnonsql.class));
      }
      return respone;
  }
}
