package com.beesdev.repository.image_repository;


import com.beesdev.model.image_model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    List<Image> findImageByAdvertisement_Id(String id);

}

