package com.tfg.digitalcitizen.platform.client_service.core.model;

import com.tfg.digitalcitizen.platform.shared.domain.valueobject.NullableStringValueObject;

public class PhoneNumber extends NullableStringValueObject {

    public static final String PHONE_PATTERN = "^\\d{9,15}$";
    public static final PhoneNumber EMPTY = new PhoneNumber("-");

    private PhoneNumber(String value) {
        super(value);
        validateFormat(value);
    }

    private void validateFormat(String value) {
        if (value != null && !value.equals("-") && !value.matches(PHONE_PATTERN)) {
            throw new IllegalArgumentException("El número de teléfono debe tener entre 9 y 15 dígitos.");
        }
    }

    public static PhoneNumber fromPrimitive(String value) {
        return (value == null || value.trim().isEmpty() || "-".equals(value))
                ? EMPTY
                : new PhoneNumber(value);
    }

    public boolean isEmpty() {
        return "-".equals(this.toPrimitive());
    }
}


