package com.jeevan.pastebin.storage;

import java.util.Optional;

public interface StorageBackend {

    String save(String content);

    Optional<String> findById(String pasteId);
}