package com.jcayllahua.demo;

import com.jcayllahua.validator.sanitizer.ClaimNumbers;
import com.jcayllahua.validator.sanitizer.RequestSanitizer;
import org.springframework.stereotype.Component;

@Component
public class ClaimDelegate {

    private final ClaimService service;

    public ClaimDelegate(ClaimService service) {
        this.service = service;
    }

    public String getClaim(String rawClaimNumber) {
        // Usar el valor DEVUELTO: la barrera está en el retorno de requireValid
        String claimNumber = ClaimNumbers.requireValid(rawClaimNumber, "claimNumber");
        return service.findClaim(claimNumber);
    }

    public String search(String rawQuery) {
        String query = RequestSanitizer.sanitize(rawQuery);
        return service.search(query);
    }

    public String addNoteUnsafe(String rawNote) {
        return service.addNote(rawNote); // sin sanitizar, a propósito
    }
}