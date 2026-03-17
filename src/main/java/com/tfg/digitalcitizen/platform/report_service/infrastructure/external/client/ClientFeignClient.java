package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient(name = "client-service", url = "${services.client-url}")
public interface ClientFeignClient {

    @GetMapping("/clients")
    Map<String, Object> getAllClients();
}
