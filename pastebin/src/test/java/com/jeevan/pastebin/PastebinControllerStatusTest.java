package com.jeevan.pastebin;

import com.jeevan.pastebin.controller.PastebinController;
import com.jeevan.pastebin.exception.PasteNotFoundException;
import com.jeevan.pastebin.exception.ServiceUnavailableException;
import com.jeevan.pastebin.service.PastebinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PastebinController.class)
class PastebinControllerStatusTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PastebinService pastebinService;

    @Test
    void shouldReturn200ForSuccessfulCreate() throws Exception {
        when(pastebinService.post("hello")).thenReturn("abc123");

        mockMvc.perform(post("/api/pastes")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("abc123"));
    }

    @Test
    void shouldReturn404ForMissingPaste() throws Exception {
        when(pastebinService.get("missing-id")).thenThrow(new PasteNotFoundException("Paste not found"));

        mockMvc.perform(get("/api/pastes/missing-id"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Paste not found"));
    }

    @Test
    void shouldReturn400ForInvalidInput() throws Exception {
        when(pastebinService.get(" ")).thenThrow(new IllegalArgumentException("Paste ID cannot be null or empty"));

        mockMvc.perform(get("/api/pastes/ "))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Paste ID cannot be null or empty"));
    }

    @Test
    void shouldReturn503WhenStorageIsUnavailable() throws Exception {
        when(pastebinService.get("db-down")).thenThrow(new ServiceUnavailableException("Storage unavailable"));

        mockMvc.perform(get("/api/pastes/db-down"))
                .andExpect(status().isServiceUnavailable())
                .andExpect(content().string("Storage unavailable"));
    }
}
