package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "device-service", url = "http://localhost:8080")
public interface DeviceFeignClient {

    @GetMapping("/devices/client/{clientId}")
    Map<String, Object> getDevicesByClient(@PathVariable Long clientId);
}

