package com.tfg.digitalcitizen.platform.line_service.application.mapper;

import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import com.tfg.digitalcitizen.platform.line_service.core.model.LineStatus;
import com.tfg.digitalcitizen.platform.line_service.core.model.simcard.SIMCard;

import java.util.List;
import java.util.stream.Collectors;

public final class LineMapper {

    private LineMapper() {}

    // Domain → DTO
    public static LineDto toDto(Line line) {
        return new LineDto(
                line.id(),
                line.phoneNumber(),
                line.tariffType(),
                line.activationDate(),

                line.simCard().iccid(),
                line.simCard().type(),
                line.simCard().pin(),
                line.simCard().puk(),
                line.simCard().operator(),

                line.status(),
                line.clientId(),
                line.employeeId(),
                line.deviceId()
        );
    }

    public static List<LineDto> toDtoList(List<Line> lines) {
        return lines.stream().map(LineMapper::toDto).collect(Collectors.toList());
    }

    // DTO → Domain
    public static Line toDomain(LineDto dto) {

        SIMCard sim = SIMCard.fromPrimitives(
                dto.getIccid(),
                dto.getSimType(),
                dto.getPin(),
                dto.getPuk(),
                dto.getOperator()
        );

        return Line.fromPrimitives(
                dto.getId(),                // puede ser null
                dto.getPhoneNumber(),
                dto.getTariffType(),
                dto.getActivationDate(),
                sim,
                LineStatus.valueOf(dto.getStatus().toUpperCase()),
                dto.getClientId(),
                dto.getEmployeeId(),
                dto.getDeviceId()
        );
    }

}

