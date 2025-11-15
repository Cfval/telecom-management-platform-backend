package com.tfg.digitalcitizen.platform.line_service.application;

import com.tfg.digitalcitizen.platform.line_service.core.ports.LineRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DELETELineUseCase {

    private final LineRepositoryPort repository;

    public void invoke(Long id) {
        repository.deleteById(id);
    }
}
