package com.tfg.digitalcitizen.platform.user_service.application;

import com.tfg.digitalcitizen.platform.user_service.application.model.UserByIdUseCaseResponse;
import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GETUserByIdUseCase {

    private final UserRepositoryPort repository;

    public UserByIdUseCaseResponse invoke(Long id) {

        User user = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        return new UserByIdUseCaseResponse(user);
    }
}
