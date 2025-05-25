package com.StackOverflow.UploaderService.controller;

import com.StackOverflow.UploaderService.dto.ImageUploadResponse;
import com.StackOverflow.UploaderService.service.UploaderServiceI;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class UploaderController {

    private static final Logger log = LoggerFactory.getLogger(UploaderController.class);
    private final UploaderServiceI uploaderService;

    public UploaderController(UploaderServiceI uploaderService) {
        this.uploaderService = uploaderService;
    }

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return new ResponseEntity<>("UploaderService is up and running", HttpStatus.OK);
    }

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        log.info("inside uploadImage");
        String op = uploaderService.uploadImage(file);

        return new ResponseEntity<>(op, HttpStatus.CREATED);
    }

}
