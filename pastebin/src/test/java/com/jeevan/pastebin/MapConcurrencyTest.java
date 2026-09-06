package com.jeevan.pastebin;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MapConcurrencyTest {

    @Test
    void shouldDemonstrateRaceCondition() throws Exception {
        // 1. Create HashMap
        Map<String, Integer> map = new HashMap<>();

        // 2. Put counter = 0
        map.put("counter", 0);

        // 3. Create ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 4. Create CountDownLatch
        CountDownLatch readyLatch = new CountDownLatch(100);
        CountDownLatch startLatch = new CountDownLatch(1);

        // 5. Create 100 tasks
        Callable<Void> task = () -> {
            readyLatch.countDown();
            startLatch.await();

            Integer current = map.get("counter");
            System.out.println("Thread " + Thread.currentThread().getName() + " observed: " + current);

            // Each task:
            // get counter
            // increment
            // put counter
            map.put("counter", current + 1);

            System.out.println("Thread " + Thread.currentThread().getName() + " wrote: " + (current + 1));
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

        // 11. Final assertion showing the race condition
        assertTrue(finalCounter < 100,
                "Expected a race condition with HashMap, but final counter was " + finalCounter);

        // 12. Shutdown executor
        executorService.shutdown();
    }
}
