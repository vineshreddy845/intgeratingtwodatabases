package com.example.integerationwithtwodatabases.response;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@ResponseBody
public class Response {
   private boolean first;
}
