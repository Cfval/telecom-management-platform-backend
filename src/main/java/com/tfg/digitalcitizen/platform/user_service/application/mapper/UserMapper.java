package com.tfg.digitalcitizen.platform.user_service.application.mapper;

import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;

import java.util.List;
import java.util.stream.Collectors;

public final class UserMapper {

    private UserMapper() {}

    // Domain → DTO
    public static UserDto toDto(User user) {
        return new UserDto(
                user.id(),
                user.fullName(),
                user.email(),
                user.department(),
                user.registrationDate(),
                user.status(),     // String: ACTIVE/INACTIVE
                user.role(),
                user.clientId(),
                user.lineId()
        );
    }

    public static List<UserDto> toDtoList(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    // DTO → Domain
    public static User toDomain(UserDto dto) {

        return User.fromPrimitives(
                dto.getId(),  // puede ser null en POST
                dto.getFullName(),
                dto.getEmail(),
                dto.getDepartment(),
                dto.getRegistrationDate(),
                UserStatus.valueOf(dto.getStatus().toUpperCase()),
                dto.getRole(),
                dto.getClientId(),
                dto.getLineId()
        );
    }
}
