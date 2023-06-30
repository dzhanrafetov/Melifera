package com.beesdev.repository.advertisement_repository;

import com.beesdev.model.advertisement_model.Category;
import com.beesdev.model.user_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {



    List<Category> findCategoryByCategoryName(String categoryName);



}
