package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.user_service.core.model.User;
import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;
import com.tfg.digitalcitizen.platform.user_service.core.ports.UserRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserDataLoader {

    @Bean
    CommandLineRunner initUsersDatabase(UserRepositoryPort repository) {
        return args -> {

            if (repository.findAll().isEmpty()) {

                repository.save(User.fromPrimitives(
                        "Carlos Martínez",
                        "carlos.martinez@company.com",
                        "IT",
                        LocalDate.now(),
                        UserStatus.ACTIVE,
                        "DevOps",
                        1L,
                        null
                ));

                repository.save(User.fromPrimitives(
                        "Laura Pérez",
                        "laura.perez@company.com",
                        "Marketing",
                        LocalDate.now(),
                        UserStatus.INACTIVE,
                        "MANAGER",
                        1L,
                        3L
                ));

                System.out.println("Datos iniciales de usuarios cargados correctamente.");
            } else {
                System.out.println("La base de datos ya contiene usuarios. No se realizó precarga.");
            }
        };
    }
}
