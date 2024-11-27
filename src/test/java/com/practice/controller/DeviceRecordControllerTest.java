package com.practice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class DeviceRecordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testEchoEndpoint() throws Exception {
        String payload = "{ \"RecordType\": \"xxx\", \"DeviceId\": \"357370040159770\", \"EventDateTime\": \"2014-05-12T05:09:48Z\", \"FieldA\": 68, \"FieldB\": \"xxx\", \"FieldC\": 123.45 }";
        mockMvc.perform(post("/api/echo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk())
                .andExpect(content().json(payload));
    }
}