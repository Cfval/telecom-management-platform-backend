package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.application.GETAllUsersUseCase;
import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import com.tfg.digitalcitizen.platform.user_service.application.mapper.UserMapper;
import com.tfg.digitalcitizen.platform.user_service.application.model.UsersUseCaseResponse;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.controller.dto.UsersResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GETAllUsersRestController {

    private final GETAllUsersUseCase useCase;

    @Operation(summary = "Get all users")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users found successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/users")
    public ResponseEntity<UsersResponse> findAll() {

        UsersUseCaseResponse response = useCase.invoke();

        List<UserDto> dtoList = response.getUsers().stream()
                .map(UserMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new UsersResponse(dtoList, response.getTotalUsers(), response.getTotalUsersFiltered())
        );
    }
}
