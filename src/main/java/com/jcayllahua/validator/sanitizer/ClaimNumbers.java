package com.jcayllahua.validator.sanitizer;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public final class ClaimNumbers {

    private static final Pattern VALID = Pattern.compile("^\\d{1,20}$");

    /**
     * Validates and sanitizes a claim number received from the client.
     * @param claimNumber número recibido del cliente
     * @param field nombre del campo, para el mensaje de error
     * @return el número de siniestro validado y sanitizado
     * @throws IllegalArgumentException si es nulo o no cumple el formato
     */
    public static String requireValid(String claimNumber, String field) {
        String sanitized = RequestSanitizer.sanitize(claimNumber);
        if (sanitized == null || !VALID.matcher(sanitized).matches()) {
            throw new IllegalArgumentException("El campo '" + field + "' tiene un formato inválido");
        }
        return sanitized;
    }
}
