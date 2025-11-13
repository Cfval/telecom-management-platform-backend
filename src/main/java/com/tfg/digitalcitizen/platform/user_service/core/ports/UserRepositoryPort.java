package com.tfg.digitalcitizen.platform.user_service.core.ports;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import java.util.*;

public interface UserRepositoryPort {

    // Crear un nuevo empleado (POST /users)
    User save(User user);

    // Obtener todos los empleados (GET /users)
    List<User> findAll();

    // Obtener un empleado por ID (GET /users/{id})
    Optional<User> findById(Long id);

    // Actualizar información del empleado (PUT /users/{id})
    User update(User user);

    // Eliminar o marcar un empleado como inactivo (DELETE /users/{id})
    void deleteById(Long id);

    // Obtener empleados de un cliente específico (GET /users/by-client/{clientId})
    List<User> findByClientId(Long clientId);
}

