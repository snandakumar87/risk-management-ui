package com.redhat;

import io.smallrye.mutiny.Multi;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import org.jboss.resteasy.annotations.SseElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TransactionResource {

    @Inject
    EventBus eventBus;

    @GET
    @Path("/stream")
    @Produces(MediaType.APPLICATION_JSON)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Multi<JsonObject> stream()
    {
        System.out.println("Came to post call");
        return eventBus.<JsonObject>consumer("transaction_stream")
                .toMulti()
                .map(b -> b.body());
    }




    
}