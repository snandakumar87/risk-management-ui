package me.escoffier;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/transaction")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    private static final Logger LOGGER = Logger.getLogger("MovieResource");

    @Inject @Channel("transaction") Emitter<Transaction> emitter;


    @POST
    public Response enqueueMovie(Transaction transaction) {
        LOGGER.infof("Sending movie %s to Kafka", transaction.getId());
        emitter.send(transaction);
        return Response.accepted().build();
    }

}
