package com.example.universitystudentportal.service;

import com.example.universitystudentportal.model.StudentImage;
import com.example.universitystudentportal.repository.ImageRepository;
import com.example.universitystudentportal.utility.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service

public class ImageServiceImpl {



    private ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
    public  String uploadImage(MultipartFile image) throws IOException {
       StudentImage studentImage = imageRepository.save(StudentImage.builder()
                        .name(image.getOriginalFilename())
                        .type(image.getContentType())
                        .imageData(ImageUtils.compressImage(image.getBytes())).build());

       if (studentImage != null){
           return "image uploaded successfully" + image.getOriginalFilename();
       }
        return "null";
    }

    public byte[] downloadImage(String imageName){
        Optional<StudentImage> dbImageData = imageRepository.findByName(imageName);
        byte[] image = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return image;
    }
}
