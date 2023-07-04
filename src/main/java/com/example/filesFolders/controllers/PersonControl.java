package com.example.filesFolders.controllers;

import com.example.filesFolders.models.Person;
import com.example.filesFolders.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonControl {
    @Autowired
    PersonRepo personRepo;

    @GetMapping("/persons")
    public List<Person> getAllPeople(){
        return personRepo.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personRepo.findById(id);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personRepo.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
