package com.example.oauth2;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Test {
    private OAuth2Example oAuth2Example;

    @GetMapping("/test")
    public void gete(){
        oAuth2Example.gete();
    }
}
