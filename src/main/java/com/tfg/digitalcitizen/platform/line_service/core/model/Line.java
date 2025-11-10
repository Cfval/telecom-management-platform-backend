package com.tfg.digitalcitizen.platform.line_service.core.model;

import java.time.LocalDate;

public final class Line {

    private Long id;
    private final PhoneNumber phoneNumber;
    private final LineStatus status;
    private final TariffType tariffType;
    private final LocalDate activationDate;
    private final Long clientId;
    private final Long employeeId;
    private final Long deviceId;

    // --- Getters ---
    public Long id() { return id; }
    public String phoneNumber() { return phoneNumber.toPrimitive(); }
    public String status() { return status.name(); }
    public String tariffType() { return tariffType.toPrimitive(); }
    public LocalDate activationDate() { return activationDate; }
    public Long clientId() { return clientId; }
    public Long employeeId() { return employeeId; }
    public Long deviceId() { return deviceId; }

    // --- Private constructor ---
    private Line(Long id, String phoneNumber, LineStatus status, String tariffType,
                 LocalDate activationDate, Long clientId, Long employeeId, Long deviceId) {

        if (phoneNumber == null || status == null || activationDate == null || clientId == null)
            throw new IllegalArgumentException("Mandatory fields cannot be null.");

        this.id = id;
        this.phoneNumber = PhoneNumber.fromPrimitive(phoneNumber);
        this.status = status;
        this.tariffType = TariffType.fromPrimitive(tariffType);
        this.activationDate = activationDate;
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.deviceId = deviceId;
    }

    // --- Factory methods ---
    public static Line fromPrimitives(String phoneNumber, LineStatus status, String tariffType,
                                      LocalDate activationDate, Long clientId, Long employeeId, Long deviceId) {
        return new Line(null, phoneNumber, status, tariffType, activationDate, clientId, employeeId, deviceId);
    }

    public static Line fromPrimitives(Long id, String phoneNumber, LineStatus status, String tariffType,
                                      LocalDate activationDate, Long clientId, Long employeeId, Long deviceId) {
        return new Line(id, phoneNumber, status, tariffType, activationDate, clientId, employeeId, deviceId);
    }

    // --- Business logic ---
    public boolean isActive() {
        return this.status == LineStatus.ACTIVE;
    }

    public Line changeStatus(LineStatus newStatus) {
        return new Line(this.id, this.phoneNumber.toPrimitive(),
                newStatus, this.tariffType.toPrimitive(),
                this.activationDate, this.clientId, this.employeeId, this.deviceId);
    }

    public Line assignTo(Long employeeId, Long deviceId) {
        return new Line(this.id, this.phoneNumber.toPrimitive(),
                LineStatus.ACTIVE, this.tariffType.toPrimitive(),
                this.activationDate, this.clientId, employeeId, deviceId);
    }

    public Line unassign() {
        return new Line(this.id, this.phoneNumber.toPrimitive(),
                LineStatus.SUSPENDED, this.tariffType.toPrimitive(),
                this.activationDate, this.clientId, null, null);
    }
}


