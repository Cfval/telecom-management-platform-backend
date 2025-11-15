package com.tfg.digitalcitizen.platform.user_service.infrastructure.repository.entity;

import com.tfg.digitalcitizen.platform.user_service.core.model.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_status", columnList = "status"),
                @Index(name = "idx_user_client", columnList = "clientId"),
                @Index(name = "idx_user_line", columnList = "lineId")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ValueObjects → strings en DB
    @Column(nullable = false, unique = true, length = 150)
    private String fullName;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    @Column(nullable = true, length = 50)
    private String department;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private UserStatus status;  // ACTIVE / INACTIVE

    @Column(nullable = false, length = 80)
    private String role;        // UserRole como String

    // Relaciones lógicas
    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = true)
    private Long lineId;
}
