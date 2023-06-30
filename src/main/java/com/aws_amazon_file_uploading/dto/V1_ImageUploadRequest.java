package com.aws_amazon_file_uploading.dto;

import org.springframework.web.multipart.MultipartFile;

public class V1_ImageUploadRequest {
    private MultipartFile file;

    public V1_ImageUploadRequest() {
    }

    public V1_ImageUploadRequest(MultipartFile file) {
        this.file=file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }


}