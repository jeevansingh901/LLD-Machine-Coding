
package com.jeevan.pastebin.service;
import org.springframework.stereotype.Service;
import com.jeevan.pastebin.repository.PastebinRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PastebinService {

    private final PastebinRepository pastebinRepository;

    public String post(String content) {
        return pastebinRepository.save(content);
    }

    public String get(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }
        return pastebinRepository.get(id);
    }

    public String getStatus() {
        return "Pastebin service is running";
    }
}