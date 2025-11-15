package com.tfg.digitalcitizen.platform.client_service.infrastructure.repository.adapter;

import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import com.tfg.digitalcitizen.platform.client_service.core.ports.ClientRepositoryPort;
import com.tfg.digitalcitizen.platform.client_service.infrastructure.repository.JpaClientRepository;
import com.tfg.digitalcitizen.platform.client_service.infrastructure.repository.entity.ClientEntity;
import com.tfg.digitalcitizen.platform.client_service.infrastructure.repository.mapper.ClientEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final JpaClientRepository jpaClientRepository;

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll().stream()
                .map(ClientEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaClientRepository.findById(id)
                .map(ClientEntityMapper::toDomain);
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = ClientEntityMapper.toEntity(client);
        ClientEntity savedEntity = jpaClientRepository.save(entity);
        return ClientEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Client update(Client client) {
        ClientEntity entity = ClientEntityMapper.toEntity(client);
        ClientEntity updatedEntity = jpaClientRepository.save(entity);
        return ClientEntityMapper.toDomain(updatedEntity);
    }

    @Override
    public void deleteById(Long id) {
        jpaClientRepository.deleteById(id);
    }
}

