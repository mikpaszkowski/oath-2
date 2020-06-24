package com.paszko.oath2;


//import com.sun.org.apache.xml.internal.security.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginAPI {

    @PostMapping("/logIn")
    public String login(@RequestBody User user){

        long currentTimeMillis = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(user.getLogin())
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 20000))
                .signWith(SignatureAlgorithm.HS512 , user.getPassword())
                .compact();
                //compact -> string

    }

}
