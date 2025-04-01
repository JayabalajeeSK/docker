package com.jb.rest_demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //return json format
public class HelloController {
    @GetMapping("/hello")
    private String greet()
    {
        return "Hello World";
    }
}