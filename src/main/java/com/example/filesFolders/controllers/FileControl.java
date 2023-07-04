package com.example.filesFolders.controllers;

import com.example.filesFolders.models.File;
import com.example.filesFolders.repositories.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileControl {

    @Autowired
    FileRepo fileRepo;

    @GetMapping("/files")
    public List<File> getAllFiles(){
        return fileRepo.findAll();
    }

    @GetMapping("/files/{id}")
    public Optional<File> getFileById(@PathVariable Long id){
        return fileRepo.findById(id);
    }

    @PostMapping("/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        fileRepo.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }
}
