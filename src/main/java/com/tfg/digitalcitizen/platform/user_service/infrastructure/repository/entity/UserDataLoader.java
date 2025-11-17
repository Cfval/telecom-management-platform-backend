package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class UserDataLoader {

    private static final Random random = new Random();

    private static final String[] FIRST_NAMES = {
            "Carlos", "Laura", "Marta", "Sergio", "Ana", "David", "Lucía", "Pablo", "Elena", "Jorge",
            "Andrea", "Marcos", "Irene", "Raúl", "Cristina", "Víctor", "Daniel", "Paula", "Alba", "Rubén"
    };

    private static final String[] LAST_NAMES = {
            "García", "Pérez", "Martínez", "López", "Sánchez", "Ramírez", "Gómez", "Díaz", "Navarro",
            "Torres", "Vargas", "Castillo", "Molina", "Suárez", "Ortega", "Rubio", "Romero", "Cortés"
    };

    private static final String[] DEPARTMENTS = {
            "IT", "HR", "Marketing", "Finance", "Operations", "Support"
    };

    private static final String[] ROLES = {
            "EMPLOYEE", "MANAGER", "TECHNICIAN", "ANALYST", "SUPPORT", "ADMIN"
    };

    @Bean
    CommandLineRunner initUsersDatabase(UserRepositoryPort repository) {
        return args -> {

            if (!repository.findAll().isEmpty()) {
                System.out.println("Base de datos ya contiene usuarios. Precarga omitida.");
                return;
            }

            int totalUsers = 150;
            System.out.println("Generando " + totalUsers + " usuarios aleatorios...");

            for (int i = 1; i <= totalUsers; i++) {

                // Full Name
                String fullName = generateFullName();

                // Client ID (1..15)
                Long clientId = (long) (1 + random.nextInt(15));

                // Email using domain by client
                String email = generateEmail(fullName, clientId, i);

                // Department (80% con departamento)
                String department = randomDepartment();

                // Registration date
                LocalDate registration = LocalDate.now().minusDays(random.nextInt(1500));

                // Status distribution
                UserStatus status = randomUserStatus();

                // Role
                String role = randomRole();

                // LineId (solo si ACTIVE, 40% probabilidad)
                Long lineId = assignLineId(status);

                repository.save(User.fromPrimitives(
                        fullName,
                        email,
                        department,
                        registration,
                        status,
                        role,
                        clientId,
                        lineId
                ));
            }

            System.out.println("Usuarios generados correctamente.");
        };
    }

    // ==========================================================
    // HELPERS
    // ==========================================================

    private String generateFullName() {
        String first = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String last = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return first + " " + last;
    }

    private String generateEmail(String fullName, Long clientId, int unique) {
        String normalized = normalize(fullName)
                .toLowerCase()
                .replace(" ", ".")
                .replaceAll("[^a-z0-9._-]", ""); // solo caracteres válidos

        return normalized + unique + "@client" + clientId + ".com";
    }

    private String normalize(String text) {
        String norm = java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD);
        return norm.replaceAll("\\p{InCombiningDiacriticalMarks}+", ""); // elimina tildes
    }

    private String randomDepartment() {
        return random.nextInt(100) < 80
                ? DEPARTMENTS[random.nextInt(DEPARTMENTS.length)]
                : null;
    }

    private UserStatus randomUserStatus() {
        return random.nextInt(100) < 85 ? UserStatus.ACTIVE : UserStatus.INACTIVE;
    }

    private String randomRole() {
        int p = random.nextInt(100);

        if (p < 50) return "EMPLOYEE";
        if (p < 60) return "MANAGER";
        if (p < 75) return "TECHNICIAN";
        if (p < 90) return "ANALYST";
        if (p < 95) return "SUPPORT";
        return "ADMIN";
    }

    private Long assignLineId(UserStatus status) {
        if (status != UserStatus.ACTIVE) return null;

        if (random.nextInt(100) < 40) { // 40% asignados
            return (long) (1 + random.nextInt(250)); // 1..250
        }
        return null;
    }
}

