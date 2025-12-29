package com.github.bifrurcated.credit.infrastructure.quarkus.out;

import com.github.bifrurcated.credit.account.pool.api.AccountPoolApi;
import com.github.bifrurcated.credit.account.pool.api.dto.request.NextAccountPoolRequest;
import com.github.bifrurcated.credit.account.pool.api.dto.response.NextAccountPoolResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "account-pool-api")
@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AccountPoolRestClient extends AccountPoolApi {

    @POST
    @Path("/next")
    @Override
    NextAccountPoolResponse next(NextAccountPoolRequest request);
}
