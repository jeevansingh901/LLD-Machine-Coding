
package com.jeevan.pastebin.controller;

import com.jeevan.pastebin.service.PastebinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") 
public class PastebinController {

    private final PastebinService pastebinService;

    public PastebinController(PastebinService pastebinService) {
        this.pastebinService = pastebinService;
    }


    @PostMapping("/paste")
    public ResponseEntity<String> createPaste(@RequestBody String content) {
        // Logic to create a new paste and return its ID    
           return ResponseEntity.ok(pastebinService.post(content));
    }

    @GetMapping("/paste/{id}")
    public ResponseEntity<String> getPaste(@PathVariable @Valid String id) {   

        return ResponseEntity.ok(pastebinService.get(id));
    }       

    @GetMapping("/health")
    public String health() {
        return pastebinService.getStatus();
    }
}