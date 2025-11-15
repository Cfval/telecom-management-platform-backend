package com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.mapper;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.core.model.simcard.SIMCard;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.repository.entity.LineEntity;

public final class LineEntityMapper {

    private LineEntityMapper() {}

    // ------------ Domain → Entity ------------
    public static LineEntity toEntity(Line line) {

        return new LineEntity(
                line.id(),
                line.phoneNumber(),
                line.tariffType(),
                line.activationDate(),

                // SIMCard
                line.simCard().iccid(),
                line.simCard().type(),
                line.simCard().pin(),
                line.simCard().puk(),
                line.simCard().operator(),

                // Status
                line.statusEnum(),                  // ENUM directo

                // IDs
                line.clientId(),
                line.employeeId(),
                line.deviceId()
        );
    }

    // ------------ Entity → Domain ------------
    public static Line toDomain(LineEntity entity) {

        SIMCard sim = SIMCard.fromPrimitives(
                entity.getIccid(),
                entity.getSimType(),
                entity.getPin(),
                entity.getPuk(),
                entity.getOperator()
        );

        return Line.fromPrimitives(
                entity.getId(),
                entity.getPhoneNumber(),
                entity.getTariffType(),
                entity.getActivationDate(),
                sim,
                entity.getStatus(),
                entity.getClientId(),
                entity.getEmployeeId(),
                entity.getDeviceId()
        );
    }
}
