package com.jeevan.pastebin;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapConcurrencyTest {

    @Test
    void shouldUseComputeForSafeConcurrentIncrement() throws Exception {
        // 1. Create ConcurrentHashMap
        Map<String, Integer> map = new ConcurrentHashMap<>();

        // 2. Put counter = 0
        map.put("counter", 0);

        // 3. Create ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        // 4. Create CountDownLatch
        CountDownLatch readyLatch = new CountDownLatch(100);
        CountDownLatch startLatch = new CountDownLatch(1);

        // 5. Create 100 tasks
        Callable<Void> task = () -> {
            readyLatch.countDown();
            startLatch.await();

            map.compute("counter", (key, value) -> {
                int current = value == null ? 0 : value;
                int next = current + 1;
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " observed: " + current + " -> write: " + next);
                return next;
            });
            return null;
        };

        // 6. Submit all tasks
        java.util.List<Future<Void>> futures = new java.util.ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(executorService.submit(task));
        }

        // 7. Release start signal
        readyLatch.await();
        startLatch.countDown();

        // 8. Wait for all tasks
        for (Future<Void> future : futures) {
            future.get();
        }

        // 9. Read final counter
        Integer finalCounter = map.get("counter");

        // 10. Print final counter
        System.out.println("Final counter: " + finalCounter);

        // 11. Final assertion
        assertEquals(100, finalCounter);

        // 12. Shutdown executor
        executorService.shutdown();
    }
}
