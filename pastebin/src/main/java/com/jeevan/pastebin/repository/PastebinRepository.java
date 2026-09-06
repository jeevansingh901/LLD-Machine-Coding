package com.jeevan.pastebin.repository;

import com.jeevan.pastebin.exception.PasteNotFoundException;
import com.jeevan.pastebin.storage.StorageBackend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PastebinRepository {

    private final StorageBackend storageBackend;

    public String save(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        return storageBackend.save(content);
    }

    public String get(String pasteId) {
        if (pasteId == null || pasteId.isBlank()) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }

        return storageBackend.findById(pasteId)
                .orElseThrow(() -> new PasteNotFoundException("Paste not found for id: " + pasteId));
    }
}