package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "line-service", url = "http://localhost:8080")
public interface LineFeignClient {

    @GetMapping("/lines/client/{clientId}")
    Map<String, Object> getLinesByClient(@PathVariable Long clientId);
}


