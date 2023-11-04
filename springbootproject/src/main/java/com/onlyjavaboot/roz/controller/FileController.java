package com.onlyjavaboot.roz.controller;


import com.onlyjavaboot.roz.intities.FileResponce;
import com.onlyjavaboot.roz.services.FileServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServices fileServices;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponce> fileUpload(@RequestParam("image") MultipartFile image){
        String fileName= null;
        try {
            fileName = this.fileServices.uploadImage(path,image);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FileResponce(null, "Image is not uploaded due error on server"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new FileResponce(fileName, "Image is successfully uploaded"), HttpStatus.OK);
    }
}
