
package com.jeevan.pastebin.service;

import org.springframework.stereotype.Service;

@Service
public class PastebinService {
     
  
    private final PastebinRepository pastebinRepository;

    public String post(String content) {

       String pastebinId=pastebinRepository.save(content);
       return pastebinId;
    }

    public String get(String id) {
        return pastebinRepository.get(id);
    }
}