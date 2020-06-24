package com.paszko.oath2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OathAPI {

    @GetMapping("/api/hello")
    public String sayHello(){

        return "Hello!";
    }


}
