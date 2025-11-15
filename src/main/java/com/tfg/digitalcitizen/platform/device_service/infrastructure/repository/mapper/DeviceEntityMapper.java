package com.tfg.digitalcitizen.platform.device_service.infrastructure.repository.mapper;

import com.tfg.digitalcitizen.platform.device_service.core.model.Device;
import com.tfg.digitalcitizen.platform.device_service.core.model.DeviceStatus;
import com.tfg.digitalcitizen.platform.device_service.core.model.DeviceType;
import com.tfg.digitalcitizen.platform.device_service.infrastructure.repository.entity.DeviceEntity;

public final class DeviceEntityMapper {

    private DeviceEntityMapper() {}

    public static DeviceEntity toEntity(Device domain) {
        return new DeviceEntity(
                domain.id(),
                domain.typeEnum(),              // ENUM directo
                domain.imei(),
                domain.brand(),
                domain.model(),
                domain.serialNumber(),
                domain.os(),
                domain.statusEnum(),            // ENUM directo
                domain.activationDate(),
                domain.clientId(),
                domain.lineId(),
                domain.employeeId()
        );
    }

    public static Device toDomain(DeviceEntity entity) {
        return Device.fromPrimitives(
                entity.getId(),
                entity.getType(),              // ENUM directo
                entity.getImei(),
                entity.getBrand(),
                entity.getModel(),
                entity.getSerialNumber(),
                entity.getOs(),
                entity.getStatus(),            // ENUM directo
                entity.getActivationDate(),
                entity.getClientId(),
                entity.getLineId(),
                entity.getEmployeeId()
        );
    }
}


