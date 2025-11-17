package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository;

import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaLineRepository extends JpaRepository<LineEntity, Long> {

    List<LineEntity> findByStatus(LineStatus status);

    List<LineEntity> findByClientId(Long clientId);
}
