package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private final UserDto user;
}
