package com.jeevan.pastebin.repository;

import com.jeevan.pastebin.exception.PasteNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PastebinRepository {

    private final Map<String, String> pasteStorage = new ConcurrentHashMap<>();

    public String save(String content) {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        String pasteId = UUID.randomUUID().toString();
        pasteStorage.put(pasteId, content);
        return pasteId;
    }

    public String get(String pasteId) {
        if (pasteId == null || pasteId.isBlank()) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }

        if (!pasteStorage.containsKey(pasteId)) {
            throw new PasteNotFoundException("Paste not found for id: " + pasteId);
        }

        return pasteStorage.get(pasteId);
    }
}