package com.jeevan.pastebin.storage;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryStorageBackend implements StorageBackend {

    private final Map<String, String> pasteStorage = new ConcurrentHashMap<>();

    @Override
    public String save(String content) {
        String pasteId = UUID.randomUUID().toString();
        pasteStorage.put(pasteId, content);
        return pasteId;
    }

    @Override
    public Optional<String> findById(String pasteId) {
        return Optional.ofNullable(pasteStorage.get(pasteId));
    }
}