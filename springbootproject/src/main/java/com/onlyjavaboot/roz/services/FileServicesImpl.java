package com.onlyjavaboot.roz.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServicesImpl implements FileServices {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //File name
        String name=file.getOriginalFilename();

        //Fullpath

        String randomID= UUID.randomUUID().toString();
        String FileName1= randomID.concat(name.substring(name.lastIndexOf(".")));

        String filePath=path+File.separator+FileName1;

        //Create folder if not created
        File f=new File(path);
        if (!f.exists()){
            f.mkdir();
        }

        //File copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }
}
