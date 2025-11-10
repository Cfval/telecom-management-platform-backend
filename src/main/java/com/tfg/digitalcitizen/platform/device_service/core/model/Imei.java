package com.tfg.digitalcitizen.platform.device_service.core.model;

import com.tfg.digitalcitizen.platform.shared.domain.valueobject.NonNullableStringValueObject;

public class Imei extends NonNullableStringValueObject {

    public static final String IMEI_PATTERN = "^\\d{15}$";

    private Imei(String value) {
        super(value);
        validateFormat(value);
    }

    private void validateFormat(String value) {
        if (!value.matches(IMEI_PATTERN)) {
            throw new IllegalArgumentException("El IMEI debe contener exactamente 15 dígitos numéricos.");
        }
    }

    public static Imei fromPrimitive(String value) {
        return new Imei(value);
    }
}

