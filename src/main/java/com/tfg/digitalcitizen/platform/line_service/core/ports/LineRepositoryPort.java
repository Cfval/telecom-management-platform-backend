package com.tfg.digitalcitizen.platform.line_service.core.ports;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import java.util.*;

public interface LineRepositoryPort {

    // Crear una nueva línea (POST /lines)
    Line save(Line line);

    // Obtener todas las líneas (GET /lines)
    List<Line> findAll();

    // Obtener una línea por su ID (GET /lines/{id})
    Optional<Line> findById(Long id);

    // Actualizar una línea existente (PUT /lines/{id})
    Line update(Line line);

    // Dar de baja o eliminar una línea (DELETE /lines/{id})
    void deleteById(Long id);

    // Obtener todas las líneas activas (GET /lines/active)
    List<Line> findActiveLines();
}

