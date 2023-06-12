package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/","https://d2sedfhgvk3bdp.cloudfront.net/"})
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/file/uploadToS3")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file){
        return new ResponseEntity<>(storageService.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/file/downloadFromS3/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
        System.out.println("Method called");
         byte[] data= storageService.downloadFile(fileName);
         ByteArrayResource resource = new ByteArrayResource(data);
         return ResponseEntity
                 .ok()
                 .contentLength(data.length).header("Content-type","application/octet-stream")
                 .header("Content-disposition","attachment; filename=\""+fileName+"\"")
                 .body(resource);
    }

    @DeleteMapping("/file/deleteFromS3/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return new ResponseEntity<>(storageService.deleteFile(fileName),HttpStatus.OK);
    }

    @GetMapping("/file/displayS3Image/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) {
        return storageService.displayImage(filename);
    }

}
