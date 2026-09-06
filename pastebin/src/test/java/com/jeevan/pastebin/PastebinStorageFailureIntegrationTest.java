package com.jeevan.pastebin;

import com.jeevan.pastebin.storage.FailingStorageBackend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(FailingStorageBackend.class)
class PastebinStorageFailureIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturn503WhenStorageBackendFails() throws Exception {
        mockMvc.perform(get("/api/pastes/any-id"))
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().string("Storage unavailable"));
    }
}