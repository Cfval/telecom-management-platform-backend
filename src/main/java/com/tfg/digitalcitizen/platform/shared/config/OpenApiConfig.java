package com.tfg.digitalcitizen.platform.shared.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Corporate Device Management API",
                version = "1.0.0",
                description = "REST API for managing corporate mobile assets: clients, employees, devices, and SIM lines."
        ),
        tags = {
                @Tag(name = "Clients",   description = "Client company management"),
                @Tag(name = "Devices",   description = "Corporate device management"),
                @Tag(name = "Lines",     description = "SIM line management"),
                @Tag(name = "Employees", description = "Employee management"),
                @Tag(name = "Reports",   description = "Reporting and analytics")
        }
)
public class OpenApiConfig {
}
