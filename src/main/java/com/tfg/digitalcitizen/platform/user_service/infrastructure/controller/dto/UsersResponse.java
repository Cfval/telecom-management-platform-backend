package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UsersResponse {
    private final List<UserDto> users;
    private final Integer totalUsers;
    private final Integer totalUsersFiltered;
}
