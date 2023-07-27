package com.example.universitystudentportal.controller;

import com.example.universitystudentportal.service.ImageServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping
public class ImageController {

    private final ImageServiceImpl imageServiceImpl;

    public ImageController(ImageServiceImpl imageServiceImpl) {
        this.imageServiceImpl = imageServiceImpl;
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<?> downloadImage(@PathVariable String imageName){
        byte[] imageData = imageServiceImpl.downloadImage(imageName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

    }


    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
       String imageUpload = imageServiceImpl.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(imageUpload);
    }
}
