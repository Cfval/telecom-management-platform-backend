package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.util;

import java.util.List;
import java.util.Map;

public final class MapUtils {

    private MapUtils() {}

    public static Long num(Object o) {
        return (o instanceof Number n) ? n.longValue() : null;
    }

    public static String str(Object o) {
        return o != null ? o.toString() : null;
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> list(Object o) {
        return (o instanceof List<?> l)
                ? (List<Map<String, Object>>) l
                : List.of();
    }
}

