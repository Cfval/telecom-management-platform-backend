package com.tfg.digitalcitizen.platform.device_service.core.model;

import com.tfg.digitalcitizen.platform.shared.domain.valueobject.NonNullableStringValueObject;

public class Model extends NonNullableStringValueObject {

    public static final int MAX_LENGTH = 50;

    private Model(String value) {
        super(value);
        validateFormat(value);
    }

    private void validateFormat(String value) {
        if (value.isBlank() || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("El modelo no puede estar vacío ni superar los 50 caracteres.");
        }
    }

    public static Model fromPrimitive(String value) {
        return new Model(value);
    }
}
