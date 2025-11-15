package com.tfg.digitalcitizen.platform.user_service.application.model;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class UserByIdUseCaseResponse {
    private final User user;
}
