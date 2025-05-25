package com.StackOverflow.UploaderService.service;

import com.StackOverflow.UploaderService.dto.ImageUploadResponse;
import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CloudinaryUploaderService implements UploaderServiceI {

    private static final Logger log = LoggerFactory.getLogger(CloudinaryUploaderService.class);
    @Value("${cloudinaryFolderName}")
    private String cloudinaryFolderName;

    private final Cloudinary cloudinary;

    public CloudinaryUploaderService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        try{
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", cloudinaryFolderName);
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            String url = cloudinary.url().secure(true).generate(publicId);

            return url;
        }catch (IOException e){
            log.error("Error while uploading file {}", e.getLocalizedMessage());
        }

        return null;
    }
}
