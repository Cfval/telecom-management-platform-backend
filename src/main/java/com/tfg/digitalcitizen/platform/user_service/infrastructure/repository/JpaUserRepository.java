package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository;

import com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByClientId(Long clientId);
}
