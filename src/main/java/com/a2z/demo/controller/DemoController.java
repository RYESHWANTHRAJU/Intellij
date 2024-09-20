package com.a2z.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wish")
public class DemoController {

    @GetMapping("say1")
    public ResponseEntity<String> getWish(){
        return ResponseEntity.ok("hi, hello world, this is my first API");
    }

    @GetMapping("say2")
    public ResponseEntity<String> getSecondWish(){
        return ResponseEntity.ok("hi, hello world, this is my second API");
    }
}
