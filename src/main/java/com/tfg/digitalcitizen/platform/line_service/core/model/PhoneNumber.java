package com.tfg.digitalcitizen.platform.line_service.core.model;

import com.tfg.digitalcitizen.platform.shared.domain.valueobject.NonNullableStringValueObject;

public class PhoneNumber extends NonNullableStringValueObject {

    public static final String PHONE_PATTERN = "^\\d{9,15}$";

    private PhoneNumber(String value) {
        super(value);
        validateFormat(value);
    }

    private void validateFormat(String value) {
        if (!value.matches(PHONE_PATTERN)) {
            throw new IllegalArgumentException("El número de teléfono debe tener entre 9 y 15 dígitos.");
        }
    }

    public static PhoneNumber fromPrimitive(String value) {
        return new PhoneNumber(value);
    }
}

