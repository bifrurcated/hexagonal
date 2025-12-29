package com.github.bifrurcated.credit.infrastructure.spring.in;

import com.github.bifrurcated.credit.domain.spi.stubs.Stub;
import com.github.bifrurcated.credit.infrastructure.spring.config.DomainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreditRestController.class)
@Import({DomainConfig.class})
class CreditRestControllerTest {

    @TestConfiguration
    @ComponentScan(
            basePackages = {"com.github.bifrurcated.credit.domain", "com.github.bifrurcated.credit.infrastructure.spring.in.mapper"},
            includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Stub.class})})
    static class StubConfiguration {
    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_user_open_credit() throws Exception {
        String json = """
                {
                    "userId": "ff23888c-e460-4835-8681-eca7c710d978",
                    "amount": 1000000.00,
                    "expirationDate": "2026-12-27"
                }
                """;

        mockMvc.perform(post("/credit/open")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("c76ab6cf-d892-4ca8-97ba-6ce55965ada9"))
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.number").value("1234567890"));
    }
}
