package com.beesdev.shop.repository;

import com.beesdev.shop.dto.UserDto;
import com.beesdev.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByMail(String mail);

}