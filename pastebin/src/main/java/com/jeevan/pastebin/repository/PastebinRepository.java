package com.jeevan.pastebin.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PastebinRepository {

    private final Map<String, String> pasteStorage = new ConcurrentHashMap<>();

    public String save(String content) {
        String pasteId = UUID.randomUUID().toString();
        pasteStorage.put(pasteId, content);
        return pasteId;
    }

    public String get(String pasteId) {
        if (!pasteStorage.containsKey(pasteId)) {
            throw new IllegalArgumentException("Paste ID cannot be null or empty");
        }
        return pasteStorage.get(pasteId);
    }
}