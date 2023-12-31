package com.beesdev.repository.confirmation_token_repository;

import com.beesdev.model.confirmation_token_model.ConfirmationToken;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken,Long> {
    Optional<ConfirmationToken> findByToken(String token);
    @Transactional
    void deleteByUserId(Long userId);

}
