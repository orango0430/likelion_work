package org.exaple.like_lion_pbl.class5.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hellocontroller {
    @GetMapping("/hello")
    public String hello(){
        return "Hello,LikeLions!";
    }
}
