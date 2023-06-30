package com.aws_amazon_file_uploading.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.beesdev.model.advertisement_model.Advertisement;
import com.beesdev.service.advertisement_service.AdvertisementService;
import com.aws_amazon_file_uploading.dto.V1_ImageDto;
import com.aws_amazon_file_uploading.dto.V1_ImageDtoConverter;
import com.aws_amazon_file_uploading.dto.V1_ImageUploadRequest;
import com.aws_amazon_file_uploading.model.V1_Image;
import com.aws_amazon_file_uploading.repository.V1_ImageRepository;
import com.beesdev.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class V1_ImageService {

    @Value("${application.bucket.name}")
    private String bucketName;
    private final V1_ImageDtoConverter converter;
    private final AmazonS3 awsS3Client;
    private final AdvertisementService advertisementService;
    private final V1_ImageRepository repository;

    public V1_ImageService(V1_ImageDtoConverter converter, AmazonS3 awsS3Client, AdvertisementService advertisementService, V1_ImageRepository repository) {
        this.converter = converter;
        this.awsS3Client = awsS3Client;
        this.advertisementService = advertisementService;
        this.repository = repository;
    }


    public V1_ImageDto uploadImage(String id, V1_ImageUploadRequest request) throws IOException {
        Advertisement advertisement = advertisementService.findAdvertisementById(id);
        String preFolderName = advertisement.getUser().getId() + " "
                + advertisement.getUser().getUsername();

        String subFolderName = advertisement.getId() + "  added time: "
                + LocalDateTime.now();
        String Folder = preFolderName + "/" + subFolderName + "";


        InputStream inputStream = request.getFile().getInputStream();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(request.getFile().getContentType());
        objectMetadata.setContentLength(request.getFile().getSize());

        awsS3Client.putObject(bucketName, Folder, inputStream, objectMetadata);
        String objectUrl = awsS3Client.getUrl(bucketName, Folder).toExternalForm();
        V1_Image v1Image = new V1_Image(Folder, objectUrl, advertisement);


        return converter.convert(repository.save(v1Image));
    }
        public void deleteImage(Long id) {
            findImageById(id);
        repository.deleteById(id);
    }

    public V1_Image findImageById(Long id) {
       return  repository.findById(id).orElseThrow(() -> new NotFoundException("Image couldn't found by id:  " + id));
    }


    public List<V1_ImageDto>getAllImages() {
        return converter.convert(repository.findAll());
    }
    public List<V1_ImageDto> getImagesByAdvertisementId(String id) {
        return converter.convert(repository.findImageByAdvertisement_Id(id));
    }

    public byte[] downloadFile(String fileName) {
        S3Object s3Object = awsS3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String deleteFile(String fileName) {
        awsS3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }


    public List<String> getBucketList() {
        return awsS3Client.listBuckets().stream().map(Bucket::getName).collect(Collectors.toList());

    }

    public List<String> listFiles(final String bucketName) throws AmazonClientException {
        List<String> keys = new ArrayList<>();
        ObjectListing objectListing = awsS3Client.listObjects(bucketName);

        while (true) {
            List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            if (objectSummaries.isEmpty()) {
                break;
            }

            objectSummaries.stream()
                    .map(S3ObjectSummary::getKey)
                    .filter(key -> !key.endsWith("/"))////towa ni trqbwa
                    .forEach(keys::add);

            objectListing = awsS3Client.listNextBatchOfObjects(objectListing);
        }

        return keys;
    }


    public URL getFile(String fileName) {
        S3Object s3Object = awsS3Client.getObject(bucketName, fileName);
        URL obj = awsS3Client.getUrl(bucketName, fileName);
        System.out.println(obj);
        System.out.println(s3Object.getKey());



        return obj;
    }


}

