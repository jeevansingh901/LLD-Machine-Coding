
package com.jeevan.pastebin.service;

import com.jeevan.pastebin.repository.PastebinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PastebinService {

    private final PastebinRepository pastebinRepository;

    public String post(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        return pastebinRepository.save(content);
    }

    public String get(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }

        return pastebinRepository.get(id);
    }

    public String getStatus() {
        return "Pastebin service is running";
    }
}