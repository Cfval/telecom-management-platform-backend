package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.core.model.simcard.SIMCard;
import com.tfg.digitalcitizen.platform.line_service.core.ports.LineRepositoryPort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LineDataLoader {

    @Bean
    public CommandLineRunner initLinesDatabase(LineRepositoryPort repository) {
        return args -> {

            if (repository.findAll().isEmpty()) {

                SIMCard sim1 = SIMCard.fromPrimitives("8934501234567891111", "ESIM", "1111", "22222222", "Orange");
                SIMCard sim2 = SIMCard.fromPrimitives("8934509876543212222", "SIM", "1234", "99999999", "Movistar");

                repository.save(Line.fromPrimitives(
                        "600123456",
                        "PREMIUM",
                        LocalDate.now(),
                        sim1,
                        LineStatus.ACTIVE,
                        1L,
                        1L,
                        null
                ));

                repository.save(Line.fromPrimitives(
                        "699998877",
                        "BASIC",
                        LocalDate.now(),
                        sim2,
                        LineStatus.SUSPENDED,
                        1L,
                        null,
                        null
                ));

                System.out.println("Datos iniciales de líneas cargados correctamente.");
            } else {
                System.out.println("La base de datos ya contiene líneas. No se realizó precarga.");
            }
        };
    }
}
