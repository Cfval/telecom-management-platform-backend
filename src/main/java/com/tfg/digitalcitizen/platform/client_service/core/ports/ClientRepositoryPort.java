package com.tfg.digitalcitizen.platform.client_service.core.ports;

import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import java.util.*;

public interface ClientRepositoryPort {

    // Crear un nuevo cliente (POST /clients)
    Client save(Client client);

    // Obtener todos los clientes (GET /clients)
    List<Client> findAll();

    // Obtener un cliente por ID (GET /clients/{id})
    Optional<Client> findById(Long id);

    // Actualizar un cliente existente (PUT /clients/{id})
    Client update(Client client);

    // Dar de baja o eliminar un cliente (DELETE /clients/{id})
    void deleteById(Long id);
}

