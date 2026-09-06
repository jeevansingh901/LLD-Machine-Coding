
package com.jeevan.pastebin.service;

import com.jeevan.pastebin.exception.ServiceUnavailableException;
import com.jeevan.pastebin.repository.PastebinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PastebinService {

    private final PastebinRepository pastebinRepository;

    public String post(String content) {
        try {
            return pastebinRepository.save(content);
        } catch (Exception e) {
            throw new ServiceUnavailableException("Service unavailable while creating paste");
        }
    }

    public String get(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }

        try {
            return pastebinRepository.get(id);
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                throw e;
            }
            throw new ServiceUnavailableException("Service unavailable while fetching paste");
        }
    }

    public String getStatus() {
        return "Pastebin service is running";
    }
}