package com.tfg.digitalcitizen.platform.device_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.device_service.application.GETDevicesByClientIdUseCase;
import com.tfg.digitalcitizen.platform.device_service.application.dto.DeviceDto;
import com.tfg.digitalcitizen.platform.device_service.application.mapper.DeviceMapper;
import com.tfg.digitalcitizen.platform.device_service.application.model.DevicesUseCaseResponse;
import com.tfg.digitalcitizen.platform.device_service.infrastructure.controller.dto.DevicesResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Devices")
@RestController
@RequiredArgsConstructor
public class GETDevicesByClientRestController {

    private final GETDevicesByClientIdUseCase useCase;

    @Operation(summary = "Get devices filtered by client ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Devices found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid client ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/devices/client/{clientId}")
    public ResponseEntity<DevicesResponse> findByClient(@PathVariable Long clientId) {

        DevicesUseCaseResponse response = useCase.invoke(clientId);

        List<DeviceDto> dtoList = response.getDevices().stream()
                .map(DeviceMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new DevicesResponse(dtoList, response.getTotalDevices(), response.getTotalDevicesFiltered())
        );
    }
}
