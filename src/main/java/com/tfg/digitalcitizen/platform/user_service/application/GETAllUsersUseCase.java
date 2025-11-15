package com.tfg.digitalcitizen.platform.user_service.application;

import com.tfg.digitalcitizen.platform.user_service.application.model.UsersUseCaseResponse;
import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GETAllUsersUseCase {

    private final UserRepositoryPort repository;

    public UsersUseCaseResponse invoke() {

        List<User> users = repository.findAll();
        Integer totalUsers = users.size();
        Integer totalUsersFiltered = users.size();

        return new UsersUseCaseResponse(users, totalUsers, totalUsersFiltered);
    }
}
