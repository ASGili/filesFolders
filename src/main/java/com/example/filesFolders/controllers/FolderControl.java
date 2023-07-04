package com.example.filesFolders.controllers;

import com.example.filesFolders.models.Folder;
import com.example.filesFolders.repositories.FolderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderControl {
    @Autowired
    FolderRepo folderRepo;

    @GetMapping("/folders")
    public List<Folder> getAllFiles(){
        return folderRepo.findAll();
    }

    @GetMapping("/folders/{id}")
    public Optional<Folder> getFolderById(@PathVariable Long id){
        return folderRepo.findById(id);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> createFile(@RequestBody Folder folder){
        folderRepo.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }
}
