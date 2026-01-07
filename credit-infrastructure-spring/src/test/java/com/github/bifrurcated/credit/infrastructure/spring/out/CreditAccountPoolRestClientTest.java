package com.github.bifrurcated.credit.infrastructure.spring.out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.test.autoconfigure.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(
        value = {AccountPoolRestClient.class, CreditAccountPoolRestClient.class},
        properties = "account-pool.rest-client.enabled=true"
)
class CreditAccountPoolRestClientTest {

    @TestConfiguration
    static class TestHttpClientConfig {

        @Bean
        public AccountPoolRestClient testAccountPoolRestClient(RestClient.Builder builder) {
            RestClient restClient = builder.baseUrl("http://account-pool").build();
            HttpServiceProxyFactory factory = HttpServiceProxyFactory
                    .builderFor(RestClientAdapter.create(restClient)).build();
            return factory.createClient(AccountPoolRestClient.class);
        }
    }

    @Autowired
    MockRestServiceServer mockServer;

    @Autowired
    CreditAccountPoolRestClient creditAccountPoolRestClient;

    @Test
    void getAccountNumber_whenPostNextAccount_thenReturnOneCreditAccount() throws Exception {
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

        var number = creditAccountPoolRestClient.getAccountNumber();

        assertEquals("46422696903503697696", number);
        mockServer.verify();
    }
}