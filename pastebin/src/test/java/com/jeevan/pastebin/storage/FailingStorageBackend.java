package com.jeevan.pastebin.storage;

import com.jeevan.pastebin.exception.StorageAccessException;
import org.springframework.context.annotation.Primary;

import java.util.Optional;

@Primary
public class FailingStorageBackend implements StorageBackend {

    @Override
    public String save(String content) {
        throw new StorageAccessException("Storage is down");
    }

    @Override
    public Optional<String> findById(String pasteId) {
        throw new StorageAccessException("Storage is down");
    }
}