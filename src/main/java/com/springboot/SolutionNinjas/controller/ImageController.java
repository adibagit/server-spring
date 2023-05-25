package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.dto.ImageDto;
import com.springboot.SolutionNinjas.model.Image;
import com.springboot.SolutionNinjas.service.ImageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ImageController {
    @Autowired
    private ImageService imageService;

    private static final String UPLOAD_FOLDER = "uploads/";

    @GetMapping("/image")
    public ResponseEntity<List<Image>> getImages() {
        return new ResponseEntity<List<Image>>(imageService.getImages(), HttpStatus.OK);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Image> getImage(@PathVariable int id) {
        return new ResponseEntity<Image>(imageService.getOneImage(id),HttpStatus.OK);
    }

    @DeleteMapping("/image")
    public String deleteImage(@RequestParam int id) {
        imageService.deleteImage(id);
        return "Image having id : "+id+" has been deleted successfully.";
    }

    @PostMapping("/image")
    public ResponseEntity<Image> insertImage(@Valid @RequestBody Image image) {
        return new ResponseEntity<Image>(imageService.insertImage(image),HttpStatus.CREATED);
    }

    @PutMapping("/image/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable int id,@RequestBody Image image ) {
        image.setImageid(id);
        return new ResponseEntity<Image>(imageService.updateImage(image),HttpStatus.OK);
    }

    @GetMapping("/imageByTicket/{ticketId}")
    public List<ImageDto> getImagesByTicket(@PathVariable int ticketId) {
        return imageService.allImagesByTicket(ticketId);
    }

    @PostMapping("/image/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            // Save the file to the upload folder
            String filename = file.getOriginalFilename();
            String filepath = Paths.get(UPLOAD_FOLDER, filename).toString();
            Files.copy(file.getInputStream(), Paths.get(filepath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File name : "+filename);
            System.out.println("File path : "+filepath);
            // Return the file path
            return ResponseEntity.ok(filepath);
        } catch (IOException e) {
            // Handle the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }
}
