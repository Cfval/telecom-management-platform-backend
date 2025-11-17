package com.tfg.digitalcitizen.platform.device_service.application;

import com.tfg.digitalcitizen.platform.device_service.application.model.DevicesUseCaseResponse;
import com.tfg.digitalcitizen.platform.device_service.core.model.Device;
import com.tfg.digitalcitizen.platform.device_service.core.ports.DeviceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GETDevicesByClientIdUseCase {

    private final DeviceRepositoryPort repository;

    public DevicesUseCaseResponse invoke(Long clientId) {
        if (clientId == null) {
            throw new IllegalArgumentException("Client ID cannot be null");
        }

        List<Device> devices = repository.findByClientId(clientId);
        Integer totalDevices = devices.size();
        Integer totalDevicesFiltered = devices.size(); // TODO: implementar filtros

        return new DevicesUseCaseResponse(devices, totalDevices, totalDevicesFiltered);
    }
}
