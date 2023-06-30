package com.aws_amazon_file_uploading.dto;

public class V1_ImageDto {
    private Long image_id;
    private String name;
    private String url;


    public V1_ImageDto() {
    }

    public V1_ImageDto(Long image_id, String name, String url) {
        this.image_id = image_id;
        this.name = name;
        this.url = url;
    }

    public V1_ImageDto(String name, String url) {
        this.name = name;
        this.url = url;
    }





    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Long getImage_id() {
        return image_id;
    }
}