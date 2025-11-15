package com.tfg.digitalcitizen.platform.device_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.device_service.application.GETDevicesByEmployeeUseCase;
import com.tfg.digitalcitizen.platform.device_service.application.dto.DeviceDto;
import com.tfg.digitalcitizen.platform.device_service.application.mapper.DeviceMapper;
import com.tfg.digitalcitizen.platform.device_service.application.model.DevicesUseCaseResponse;
import com.tfg.digitalcitizen.platform.device_service.infrastructure.controller.dto.DevicesResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GETDevicesByEmployeeRestController {

    private final GETDevicesByEmployeeUseCase useCase;

    @Operation(summary = "Get devices assigned to an employee")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Devices found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid employee ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/devices/employee/{employeeId}")
    public ResponseEntity<DevicesResponse> findByEmployee(@PathVariable Long employeeId) {

        DevicesUseCaseResponse devicesResponse = useCase.invoke(employeeId);

        List<DeviceDto> dtoList = devicesResponse.getDevices().stream()
                .map(DeviceMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new DevicesResponse(dtoList,
                        devicesResponse.getTotalDevices(),
                        devicesResponse.getTotalDevicesFiltered())
        );
    }
}
