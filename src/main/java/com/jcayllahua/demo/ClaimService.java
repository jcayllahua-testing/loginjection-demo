package com.jcayllahua.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClaimService {

    public String findClaim(String claimNumber) {
        log.info("Looking up claim {}", claimNumber);
        return "claim " + claimNumber;
    }

    public String search(String query) {
        log.info("Searching claims for {}", query);
        return "results";
    }

    public String addNote(String note) {
        log.warn("Adding note {}", note);
        return "ok";
    }
}
