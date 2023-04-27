package com.springboot.SolutionNinjas.controller;

import com.springboot.SolutionNinjas.model.Image;
import com.springboot.SolutionNinjas.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private ImageService imageService;

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
}
