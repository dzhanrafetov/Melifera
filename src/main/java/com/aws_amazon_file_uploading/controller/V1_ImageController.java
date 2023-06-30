package com.aws_amazon_file_uploading.controller;

import com.aws_amazon_file_uploading.dto.V1_ImageDto;
import com.aws_amazon_file_uploading.dto.V1_ImageUploadRequest;
import com.aws_amazon_file_uploading.service.V1_ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/file")
public class V1_ImageController {


    private final V1_ImageService v1ImageService;

    public V1_ImageController(V1_ImageService v1ImageService) {
        this.v1ImageService = v1ImageService;
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<List<V1_ImageDto>> getImagesByAdvertisementId(@PathVariable String id) {
        return ResponseEntity.ok(v1ImageService.getImagesByAdvertisementId(id));

    }
    @GetMapping("admin/")
    public ResponseEntity<List<V1_ImageDto>> getAllImages() {
        return ResponseEntity.ok(v1ImageService.getAllImages());
    }
    


    @PostMapping("/upload/{id}")
    public ResponseEntity<V1_ImageDto> uploadImage
            (@PathVariable String id,
             @RequestParam("file") MultipartFile file) throws IOException {
        V1_ImageUploadRequest request = new V1_ImageUploadRequest(file);
        return ResponseEntity.ok
                (v1ImageService.
                        uploadImage(id,request));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable("id") Long id) {
        v1ImageService.deleteImage(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("admin/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = v1ImageService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("admin/deleteByFileName/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(v1ImageService.deleteFile(fileName), HttpStatus.OK);
    }


    @GetMapping("admin/{bucketName}")
    public ResponseEntity<?> listFiles(
            @PathVariable("bucketName") String bucketName) {
        return ResponseEntity.ok(v1ImageService.listFiles(bucketName));
    }





}