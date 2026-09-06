package com.jeevan.pastebin;

import com.jeevan.pastebin.service.PastebinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PastebinServiceConcurrencyTest {

    @Autowired
    private PastebinService pastebinService;

    @Test
    void shouldCreateUniquePasteIdsAcrossConcurrentCalls() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            List<Callable<String>> tasks = java.util.stream.IntStream.range(0, 100)
                    .mapToObj(i -> (Callable<String>) () -> pastebinService.post("hello"))
                    .toList();

            List<Future<String>> futures = executorService.invokeAll(tasks);
            List<String> pasteIds = futures.stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .toList();

            Set<String> uniqueIds = new HashSet<>(pasteIds);

            assertEquals(100, pasteIds.size());
            assertEquals(100, uniqueIds.size());
        } finally {
            executorService.shutdown();
        }
    }
}
