
package com.jeevan.pastebin.controller;

import com.jeevan.pastebin.service.PastebinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PastebinController {

    private final PastebinService pastebinService;

    public PastebinController(PastebinService pastebinService) {
        this.pastebinService = pastebinService;
    }

    @PostMapping("/pastes")
    public ResponseEntity<String> createPaste(@RequestBody String content) {
        return ResponseEntity.ok(pastebinService.post(content));
    }

    @GetMapping("/pastes/{id}")
    public ResponseEntity<String> getPaste(@PathVariable String id) {
        return ResponseEntity.ok(pastebinService.get(id));
    }

    @GetMapping("/health")
    public String health() {
        return pastebinService.getStatus();
    }
}