package com.beesdev.repository.advertisement_repository;

import com.beesdev.model.advertisement_model.Advertisement;
import com.beesdev.model.advertisement_model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertisementRepository extends JpaRepository<Advertisement,String> {
    List<Advertisement> findAdvertisementByUserId(Long id);
    List<Advertisement> findByIsArchivedTrue();
    List<Advertisement> findByIsArchivedFalse();
    List<Advertisement> findByIsArchivedFalseAndCategoryId(Long id);

    List<Advertisement> findByIsArchivedTrueAndUserId(Long id);
    List<Advertisement> findByIsArchivedFalseAndUserId(Long id);

    Optional<Advertisement> findAdvertisementByIdAndUserId(String id, Long userId);

//  Advertisement findAdvertisementByIdAndUserId(String id, Long userId);


}
