package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
        name = "lines",
        indexes = {
                @Index(name = "idx_line_phone_number", columnList = "phoneNumber"),
                @Index(name = "idx_line_status", columnList = "status"),
                @Index(name = "idx_line_client", columnList = "clientId"),
                @Index(name = "idx_line_employee", columnList = "employeeId"),
                @Index(name = "idx_line_device", columnList = "deviceId"),
                @Index(name = "idx_line_iccid", columnList = "iccid")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos de la línea
    @Column(nullable = false, unique = true, length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String tariffType;

    @Column(nullable = false)
    private LocalDate activationDate;

    // Datos de la SIMCard
    @Column(nullable = false, unique = true, length = 25)
    private String iccid;

    @Column(nullable = false, length = 20)
    private String simType;

    @Column(nullable = false, length = 10)
    private String pin;

    @Column(nullable = false, length = 10)
    private String puk;

    @Column(nullable = false, length = 50)
    private String operator;

    // --- Estado ---
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private LineStatus status;

    // Relaciones lógicas
    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = true)
    private Long employeeId;  // la línea puede no estar asignada a un empleado

    @Column(nullable = true)
    private Long deviceId;    // la línea puede no estar asignada a un dispositivo
}
