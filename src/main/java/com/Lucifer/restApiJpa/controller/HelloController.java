package com.Lucifer.restApiJpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello(){
        return "Api is working";
    }

//        @GetMapping("/search")
//    public String search(
//            @RequestParam String keyword) {
//        return jobService.search(keyword);
//    }


}
