package com.jcayllahua.validator.sanitizer;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class RequestSanitizer {

    /** Devuelve el valor con los saltos de línea y tabuladores reemplazados por "_"; null se mantiene. */
    public static String sanitize(String value) {
        return value == null ? null : value.replaceAll("[\\r\\n\\t]", "_");
    }
}

