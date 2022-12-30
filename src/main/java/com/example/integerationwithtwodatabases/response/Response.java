package com.example.integerationwithtwodatabases.response;

import com.example.integerationwithtwodatabases.modelnonsql.modelnonsql;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Data
//@RequiredArgsConstructor
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class Response {
    // these response class we showing in response body in postman. By we assing acctually respons to
    // response class objects.
    private boolean store;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    private String describe;

    private List<modelnonsql>q;
    public List<modelnonsql> getQ() {
        return q;
    }

    public void setQ(List<modelnonsql> q) {
        this.q = q;
    }


}
