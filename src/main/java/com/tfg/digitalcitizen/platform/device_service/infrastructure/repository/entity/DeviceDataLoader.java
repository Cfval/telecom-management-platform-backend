package com.tfg.digitalcitizen.platform.device_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.device_service.core.model.*;
import com.tfg.digitalcitizen.platform.device_service.core.ports.DeviceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Slf4j
@Configuration
public class DeviceDataLoader {

    private static final Random random = new Random();

    private static final String[] BRANDS = {
            "Samsung", "Apple", "Xiaomi", "Lenovo",
            "HP", "Dell", "Huawei", "Google"
    };

    private static final String[] ANDROID_MODELS = {
            "Galaxy S21", "Galaxy A52", "Mi 11", "Pixel 6", "P50 Pro"
    };

    private static final String[] IOS_MODELS = {
            "iPhone 12", "iPhone 13", "iPhone 14"
    };

    private static final String[] LAPTOP_MODELS = {
            "ThinkPad X1", "MacBook Pro", "MateBook X", "Dell XPS 13"
    };

    private static final String[] ROUTER_MODELS = {
            "AX1800", "AX3600", "MeshPro X1"
    };

    private static final String[] OS_TYPES = {
            "Android", "iOS", "Windows", "ChromeOS", "HarmonyOS", "Linux"
    };

    @Bean
    CommandLineRunner initDevicesDatabase(DeviceRepositoryPort repository) {
        return args -> {

            if (!repository.findAll().isEmpty()) {
                log.info("Database already contains devices. Skipping data load.");
                return;
            }

            int totalDevices = 200;
            log.info("Generating {} random devices...", totalDevices);

            for (int i = 1; i <= totalDevices; i++) {

                DeviceType type = randomDeviceType();

                String imei = generateImei(i);

                String brand = randomBrand();
                String model = randomModel(type, brand);
                String os = randomOs(type);

                LocalDate activation = LocalDate.now().minusDays(random.nextInt(1500));

                DeviceStatus status = randomDeviceStatus();

                Long clientId = (long) (1 + random.nextInt(15));      // 1..15
                Long employeeId = assignEmployeeId(status);
                Long lineId = assignLineId(status, employeeId);

                repository.save(Device.fromPrimitives(
                        type,
                        imei,
                        brand,
                        model,
                        randomSerial(),
                        os,
                        status,
                        activation,
                        clientId,
                        lineId,
                        employeeId
                ));
            }

            log.info("Devices generated successfully.");
        };
    }

    // ==========================================================
    // HELPERS
    // ==========================================================

    private DeviceType randomDeviceType() {
        DeviceType[] types = DeviceType.values();
        return types[random.nextInt(types.length)];
    }

    private String randomBrand() {
        return BRANDS[random.nextInt(BRANDS.length)];
    }

    private String randomModel(DeviceType type, String brand) {
        return switch (type) {
            case SMARTPHONE -> ANDROID_MODELS[random.nextInt(ANDROID_MODELS.length)];
            case TABLET -> ANDROID_MODELS[random.nextInt(ANDROID_MODELS.length)];
            case LAPTOP -> LAPTOP_MODELS[random.nextInt(LAPTOP_MODELS.length)];
            case DESKTOP -> LAPTOP_MODELS[random.nextInt(LAPTOP_MODELS.length)];
            case SMARTWATCH -> "Watch Series " + (1 + random.nextInt(7));
            default -> "Generic Model";
        };
    }

    private String randomOs(DeviceType type) {
        return switch (type) {
            case SMARTPHONE, TABLET -> "Android";
            case SMARTWATCH -> "WearOS";
            case LAPTOP, DESKTOP -> "Windows";
            default -> OS_TYPES[random.nextInt(OS_TYPES.length)];
        };
    }

    private DeviceStatus randomDeviceStatus() {
        int p = random.nextInt(100);

        if (p < 50) return DeviceStatus.ASSIGNED;
        if (p < 75) return DeviceStatus.STORAGE;
        if (p < 85) return DeviceStatus.REPAIR;
        if (p < 90) return DeviceStatus.LOST;
        return DeviceStatus.DECOMMISSIONED;
    }

    private String generateImei(int i) {
        String prefix = "35";
        String body = String.format("%013d", i);
        return prefix + body;
    }

    private String randomSerial() {
        return "SN" + (1000 + random.nextInt(9000));
    }

    private Long assignEmployeeId(DeviceStatus status) {
        if (status != DeviceStatus.ASSIGNED) return null;

        if (random.nextInt(100) < 70) {
            return (long) (1 + random.nextInt(150));
        }
        return null;
    }

    private Long assignLineId(DeviceStatus status, Long employeeId) {
        if (status != DeviceStatus.ASSIGNED) return null;
        if (employeeId == null) return null;

        if (random.nextInt(100) < 70) {
            return (long) (1 + random.nextInt(250));
        }
        return null;
    }
}


