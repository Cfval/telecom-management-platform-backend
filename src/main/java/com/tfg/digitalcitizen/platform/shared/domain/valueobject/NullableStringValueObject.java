package com.tfg.digitalcitizen.platform.shared.domain.valueobject;

public class NullableStringValueObject extends ValueObject<String> {
    protected NullableStringValueObject(String value) {
        super(value);
    }

    protected String validate(String value) {
        return value;
    }
}
