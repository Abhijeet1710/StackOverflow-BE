package com.StackOverflow.UploaderService.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ImageUploadResponse {
    String status;
    String url;
    List<String> errors;

    public ImageUploadResponse(String status, String message, List<String> errors) {
        this.status = status;
        this.url = message;
        this.errors = errors;
    }
}
