package com.jcayllahua.demo;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimDelegate delegate;

    public ClaimController(ClaimDelegate delegate) {
        this.delegate = delegate;
    }

    // Flujo 1: validado con ClaimNumbers.requireValid → NO debe alertar en el repo sanitized
    @GetMapping("/{claimNumber}")
    public Mono<String> getClaim(@PathVariable String claimNumber) {
        return Mono.just(delegate.getClaim(claimNumber));
    }

    // Flujo 2: limpiado con RequestSanitizer.sanitize → NO debe alertar en el repo sanitized
    @GetMapping("/search")
    public Mono<String> search(@RequestParam("q") String query) {
        return Mono.just(delegate.search(query));
    }

    // Flujo 3: INSEGURO A PROPÓSITO (canario) → debe alertar en AMBOS repos
    @GetMapping("/{claimNumber}/notes/{note}")
    public Mono<String> addNote(@PathVariable String claimNumber, @PathVariable String note) {
        return Mono.just(delegate.addNoteUnsafe(note));
    }
}
