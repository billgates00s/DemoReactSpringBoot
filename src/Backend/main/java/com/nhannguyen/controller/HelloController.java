package com.nhannguyen.controller;

import com.nhannguyen.entities.Person;
import com.nhannguyen.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // allow Vite dev server
public class HelloController {
    @Autowired
    PersonService service;


    @GetMapping("/all")
    public List<Person> all() {
        return service.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Person> addNew(@RequestBody Person p) {
        return new ResponseEntity<>(service.save(p), HttpStatus.CREATED);
    }
}
