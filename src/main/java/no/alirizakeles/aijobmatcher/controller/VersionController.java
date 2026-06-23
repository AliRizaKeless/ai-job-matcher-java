package no.alirizakeles.aijobmatcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/api/version")
    public Map<String, String> version() {
        return Map.of(
                "application", "ai-job-matcher-java",
                "version", "1.0.0"
        );
    }
}