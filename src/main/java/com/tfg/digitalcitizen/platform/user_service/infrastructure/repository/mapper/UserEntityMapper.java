package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.mapper;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity.UserEntity;

public final class UserEntityMapper {

    private UserEntityMapper() {}

    // Domain → Entity
    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.id(),
                user.fullName(),
                user.email(),
                user.department(),
                user.registrationDate(),
                user.isActive() ? UserStatus.ACTIVE : UserStatus.INACTIVE,
                user.role(),
                user.clientId(),
                user.lineId()
        );
    }

    // Entity → Domain
    public static User toDomain(UserEntity entity) {
        return User.fromPrimitives(
                entity.getId(),
                entity.getFullName(),
                entity.getEmail(),
                entity.getDepartment(),
                entity.getRegistrationDate(),
                entity.getStatus(),
                entity.getRole(),
                entity.getClientId(),
                entity.getLineId()
        );
    }
}
