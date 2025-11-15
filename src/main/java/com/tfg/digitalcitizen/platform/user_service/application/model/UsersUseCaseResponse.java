package com.tfg.digitalcitizen.platform.user_service.application.model;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public final class UsersUseCaseResponse {
    private final List<User> users;
    private final Integer totalUsers;
    private final Integer totalUsersFiltered;
}
