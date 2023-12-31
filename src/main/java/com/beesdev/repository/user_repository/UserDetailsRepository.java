package com.beesdev.repository.user_repository;

import com.beesdev.model.user_model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    Optional<UserDetails> findUserDetailsByIdAndUserId(Long userd_id, Long userId);

}
