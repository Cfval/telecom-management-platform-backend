package com.tfg.digitalcitizen.platform.user_service.application;

import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import com.tfg.digitalcitizen.platform.user_service.application.mapper.UserMapper;
import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PUTUserUseCase {

    private final UserRepositoryPort repository;

    public UserDto invoke(Long id, UserDto dto) {

        User existingUser = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        UserStatus status = UserStatus.valueOf(dto.getStatus().toUpperCase());

        User updated = existingUser.updateData(
                dto.getFullName(),
                dto.getEmail(),
                dto.getDepartment(),
                status,
                dto.getRole(),
                dto.getClientId(),
                dto.getLineId()
        );

        User saved = repository.update(updated);
        return UserMapper.toDto(saved);
    }
}
