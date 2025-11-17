package com.tfg.digitalcitizen.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.tfg.digitalcitizen.platform.report_service.infrastructure.external.client")
@SpringBootApplication
public class MobileManagementPlatformApp {

	public static void main(String[] args) {
		SpringApplication.run(MobileManagementPlatformApp.class, args);
	}

}
