package com.api.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import com.api.demo.entity.Person;

@RequestMapping("/person")
public interface ApiOperations {

    @GetMapping("/{id}")
    ResponseEntity findById(Long id);

    @GetMapping(value="/all")
    ResponseEntity findAll();
    
    @GetMapping(value="/name/{name}")
    ResponseEntity findByName(String name);

    @DeleteMapping(value="/{id}")
    ResponseEntity remove(Long id);

    @PutMapping(value="/{id}")
    ResponseEntity changeName(Long id,Person person);

    @PostMapping(value="/save")
    ResponseEntity save(Person person);
}