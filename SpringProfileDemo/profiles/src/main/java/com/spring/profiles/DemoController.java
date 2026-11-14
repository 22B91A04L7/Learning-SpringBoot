package com.spring.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Value("${spring.app.message}")
    String message;

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok(message);
    }
}
