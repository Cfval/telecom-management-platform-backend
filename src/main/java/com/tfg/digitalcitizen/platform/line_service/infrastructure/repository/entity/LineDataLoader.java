package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.core.model.simcard.SIMCard;
import com.tfg.digitalcitizen.platform.line_service.core.ports.LineRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class LineDataLoader {

    private static final Random random = new Random();

    private static final String[] TARIFFS = {
            "BASIC", "STANDARD", "PREMIUM", "UNLIMITED"
    };

    private static final String[] OPERATORS = {
            "Movistar", "Orange", "Vodafone", "Pepephone"
    };

    @Bean
    CommandLineRunner initLinesDatabase(LineRepositoryPort repository) {
        return args -> {

            if (!repository.findAll().isEmpty()) {
                System.out.println("La base de datos ya contiene líneas. Precarga omitida.");
                return;
            }

            int totalLines = 250;
            System.out.println("Generando " + totalLines + " líneas aleatorias...");

            for (int i = 1; i <= totalLines; i++) {

                String phone = generatePhoneNumber(i);
                String tariff = randomTariff();
                LocalDate activation = LocalDate.now().minusDays(random.nextInt(1500));

                SIMCard simCard = randomSIMCard(i);

                LineStatus status = randomStatus();

                Long clientId = (long) (1 + random.nextInt(15)); // 1..15
                Long employeeId = assignEmployeeId(status);
                Long deviceId = assignDeviceId(status, employeeId);

                repository.save(Line.fromPrimitives(
                        phone,
                        tariff,
                        activation,
                        simCard,
                        status,
                        clientId,
                        employeeId,
                        deviceId
                ));
            }

            System.out.println("Líneas generadas correctamente.");
        };
    }

    // ==========================================================
    // HELPERS — telecom realistic generation
    // ==========================================================

    private String generatePhoneNumber(int i) {
        return "6" + String.format("%08d", i); // 600000001, etc.
    }

    private String randomTariff() {
        return TARIFFS[random.nextInt(TARIFFS.length)];
    }

    private LineStatus randomStatus() {
        int p = random.nextInt(100);

        if (p < 55) return LineStatus.ACTIVE;
        if (p < 80) return LineStatus.SUSPENDED;
        return LineStatus.DEACTIVATED;
    }

    private SIMCard randomSIMCard(int i) {
        String iccid = randomICCID(i);
        String type = randomSIMType();
        String pin = randomPIN();
        String puk = randomPUK();
        String operator = randomOperator();

        return SIMCard.fromPrimitives(iccid, type, pin, puk, operator);
    }

    private String randomICCID(int i) {
        // Siempre ICCID de 19 digitos empezando con "893450"
        String prefix = "893450"; // MNC/MCC prefijo fijo para España y operador ficticio
        String mid = String.format("%013d", i); // asegura longitud total = 6 + 13 = 19
        return prefix + mid;
    }

    private String randomSIMType() {
        int p = random.nextInt(100);

        if (p < 50) return "SIM";          // 50%
        if (p < 80) return "ESIM";         // siguiente 30%
        if (p < 90) return "DUAL SIM";     // siguiente 10%
        return "MULTISIM";                 // último 10%
    }

    private String randomPIN() {
        return String.format("%04d", random.nextInt(10000));
    }

    private String randomPUK() {
        return String.format("%08d", random.nextInt(100_000_000));
    }

    private String randomOperator() {
        return OPERATORS[random.nextInt(OPERATORS.length)];
    }

    private Long assignEmployeeId(LineStatus status) {
        if (status != LineStatus.ACTIVE) return null;

        if (random.nextInt(100) < 60) { // 60% asignadas a empleado
            return (long) (1 + random.nextInt(150)); // 1..150
        }
        return null;
    }

    private Long assignDeviceId(LineStatus status, Long employeeId) {
        if (status != LineStatus.ACTIVE) return null;
        if (employeeId == null) return null;

        if (random.nextInt(100) < 70) { // 70% con dispositivo
            return (long) (1 + random.nextInt(200)); // 1..200
        }
        return null;
    }
}

