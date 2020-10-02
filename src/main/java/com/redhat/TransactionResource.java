package com.redhat;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Multi;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import org.jboss.resteasy.annotations.SseElementType;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class TransactionResource {

    @Inject
    EventBus eventBus;



    @GET
    @Path("/stream")
    @Produces(MediaType.APPLICATION_JSON)
    public List<JsonObject> stream()
    {
      System.out.println(TransactionConsumer.returnEventBusContents());
      return TransactionConsumer.returnEventBusContents();
    }




    
}