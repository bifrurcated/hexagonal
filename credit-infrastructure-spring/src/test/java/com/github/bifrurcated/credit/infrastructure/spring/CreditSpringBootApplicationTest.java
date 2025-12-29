package com.github.bifrurcated.credit.infrastructure.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.test.autoconfigure.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockRestServiceServer
@AutoConfigureMockMvc
class CreditSpringBootApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MockRestServiceServer mockServer;

    @BeforeEach
    void setUp() {
        var responseJson = """
                {
                    "accounts": [
                        {
                            "accountId": "34de8a83-05de-42ef-bbb5-93478d0565a3",
                            "number": "46422696903503697696"
                        }
                    ]
                }
                """;
        mockServer
                .expect(method(HttpMethod.POST))
                .andExpect(requestTo("http://account-pool/accounts/next"))
                .andRespond(withSuccess(responseJson, APPLICATION_JSON));
    }

    @Test
    void open() throws Exception {
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
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.number").value("46422696903503697696"));
    }
}