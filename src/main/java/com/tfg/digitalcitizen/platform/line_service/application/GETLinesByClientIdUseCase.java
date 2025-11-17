package com.tfg.digitalcitizen.platform.line_service.application;

import com.tfg.digitalcitizen.platform.line_service.application.model.LinesUseCaseResponse;
import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.ports.LineRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GETLinesByClientIdUseCase {

    private final LineRepositoryPort repository;

    public LinesUseCaseResponse invoke(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }

        List<Line> lines = repository.findByClientId(clientId);
        Integer totalLines = lines.size();
        Integer totalLinesFiltered = lines.size();              // TODO: Implementar lógica de filtrado si es necesario

        return new LinesUseCaseResponse(lines, totalLines, totalLinesFiltered);
    }
}
