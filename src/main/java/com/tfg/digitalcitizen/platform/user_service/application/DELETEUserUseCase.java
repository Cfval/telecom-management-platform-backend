package com.tfg.digitalcitizen.platform.user_service.application;

import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DELETEUserUseCase {

    private final UserRepositoryPort repository;

    public void invoke(Long id) {
        repository.deleteById(id);
    }
}
