package com.aws_amazon_file_uploading.model;

import com.beesdev.model.advertisement_model.Advertisement;

import javax.persistence.*;

@Entity
public class V1_Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;

    public V1_Image() {
    }

    public V1_Image(Long id, String name, String url, Advertisement advertisement) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.advertisement = advertisement;
    }

    public V1_Image(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public V1_Image(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public V1_Image(String name, String url, Advertisement advertisement) {
        this.name = name;
        this.url = url;
        this.advertisement = advertisement;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }
}