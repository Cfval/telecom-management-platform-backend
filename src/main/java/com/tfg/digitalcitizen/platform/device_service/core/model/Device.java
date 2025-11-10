package com.tfg.digitalcitizen.platform.device_service.core.model;

import java.time.LocalDate;

public final class Device {

    private Long id;
    private final Imei imei;
    private final Brand brand;
    private final Model model;
    private final DeviceStatus status;
    private final LocalDate activationDate;
    private final Long clientId;
    private final Long lineId;
    private final Long employeeId;

    // Getters con conversiones a primitivos
    public Long id() { return id; }
    public String imei() { return imei.toPrimitive(); }
    public String brand() { return brand.toPrimitive(); }
    public String model() { return model.toPrimitive(); }
    public String status() { return status.name(); }
    public LocalDate activationDate() { return activationDate; }
    public Long clientId() { return clientId; }
    public Long lineId() { return lineId; }
    public Long employeeId() { return employeeId; }

    // Constructor pirvado
    private Device(Long id, String imei, String brand, String model,
                   DeviceStatus status, LocalDate activationDate,
                   Long clientId, Long lineId, Long employeeId) {

        if (imei == null || brand == null || model == null || status == null ||
                activationDate == null || clientId == null) {
            throw new IllegalArgumentException("Mandatory fields cannot be null.");
        }

        this.id = id;
        this.imei = Imei.fromPrimitive(imei);
        this.brand = Brand.fromPrimitive(brand);
        this.model = Model.fromPrimitive(model);
        this.status = status;
        this.activationDate = activationDate;
        this.clientId = clientId;
        this.lineId = lineId;
        this.employeeId = employeeId;
    }

    // Factory methods
    public static Device fromPrimitives(String imei, String brand, String model,
                                        DeviceStatus status, LocalDate activationDate,
                                        Long clientId, Long lineId, Long employeeId) {
        return new Device(null, imei, brand, model, status, activationDate, clientId, lineId, employeeId);
    }

    public static Device fromPrimitives(Long id, String imei, String brand, String model,
                                        DeviceStatus status, LocalDate activationDate,
                                        Long clientId, Long lineId, Long employeeId) {
        return new Device(id, imei, brand, model, status, activationDate, clientId, lineId, employeeId);
    }

    // Lógica de negocio
    public boolean isActive() {
        return this.status == DeviceStatus.ASSIGNED || this.status == DeviceStatus.STORAGE;
    }

    public Device markAs(DeviceStatus newStatus) {
        return new Device(this.id, this.imei.toPrimitive(), this.brand.toPrimitive(),
                this.model.toPrimitive(), newStatus, this.activationDate,
                this.clientId, this.lineId, this.employeeId);
    }

    public Device assignTo(Long lineId, Long employeeId) {
        return new Device(this.id, this.imei.toPrimitive(), this.brand.toPrimitive(),
                this.model.toPrimitive(), DeviceStatus.ASSIGNED, this.activationDate,
                this.clientId, lineId, employeeId);
    }

    public Device unassign() {
        return new Device(this.id, this.imei.toPrimitive(), this.brand.toPrimitive(),
                this.model.toPrimitive(), DeviceStatus.STORAGE, this.activationDate,
                this.clientId, null, null);
    }
}


