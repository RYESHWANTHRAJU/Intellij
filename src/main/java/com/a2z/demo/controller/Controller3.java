package com.a2z.demo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("b1")//defines the base url for the controller methods
public class Controller3
{
    @GetMapping("t1")
    public ResponseEntity<String>getReq()
    {
        return ResponseEntity.ok("hello, this is get request");
    }

    @PostMapping("t2")
    public ResponseEntity<String>postReq()
    {
        return ResponseEntity.ok("hello, this is post request");
    }

    @PutMapping("t3")
    public ResponseEntity<String>putRequest()
    {
        return ResponseEntity.ok("hello, this is put request");
    }

    @DeleteMapping("t4")
    public ResponseEntity<String>deleteRequest()
    {
        return ResponseEntity.ok("hello, this is delete request");
    }
}
