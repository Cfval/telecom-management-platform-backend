package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.application.GETUsersByClientIdUseCase;
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
public class GETUsersByClientRestController {

    private final GETUsersByClientIdUseCase useCase;

    @Operation(summary = "Get users filtered by client ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Users found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid client ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/users/client/{clientId}")
    public ResponseEntity<UsersResponse> findByClient(@PathVariable Long clientId) {

        UsersUseCaseResponse response = useCase.invoke(clientId);

        List<UserDto> dtoList = response.getUsers().stream()
                .map(UserMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new UsersResponse(dtoList, response.getTotalUsers(), response.getTotalUsersFiltered())
        );
    }
}
