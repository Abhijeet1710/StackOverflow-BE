package com.StackOverflow.UploaderService.service;

import com.StackOverflow.UploaderService.dto.ImageUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UploaderServiceI {

    String uploadImage(MultipartFile file);
}
