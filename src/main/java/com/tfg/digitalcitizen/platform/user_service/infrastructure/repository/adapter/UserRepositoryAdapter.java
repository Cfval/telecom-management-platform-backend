package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.adapter;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.JpaUserRepository;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity.UserEntity;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.mapper.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserEntityMapper.toEntity(user);
        UserEntity saved = jpaRepository.save(entity);
        return UserEntityMapper.toDomain(saved);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(UserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(UserEntityMapper::toDomain);
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserEntityMapper.toEntity(user);
        UserEntity updated = jpaRepository.save(entity);
        return UserEntityMapper.toDomain(updated);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<User> findByClientId(Long clientId) {
        return jpaRepository.findByClientId(clientId).stream()
                .map(UserEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
