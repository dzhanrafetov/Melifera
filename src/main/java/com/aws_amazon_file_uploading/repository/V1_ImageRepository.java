package com.aws_amazon_file_uploading.repository;

import com.aws_amazon_file_uploading.model.V1_Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface V1_ImageRepository extends JpaRepository<V1_Image,Long> {
    List<V1_Image> findImageByAdvertisement_Id(String id);
}
