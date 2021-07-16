package com.redhat;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TransactionConsumer {





    private static final Logger LOGGER = Logger.getLogger("TransactionCins");

//    @Incoming("txn-from-kafka")
//    public void receive(Transaction transaction) {
//        System.out.println("inside consumer");
//        LOGGER.infof("Received movie:", transaction.getId(), transaction.getAmount());
//        try {
//            if (transaction.getMerchantId().equals("MERCH0001") && transaction.getCountry().equals("IR")) {
//                LOGGER.info("message check failed");
//            } else if(transaction.getCountry().equals("US") && transaction.getMerchantId().equals("MERCH0002")){
//                LOGGER.info("message check failed");
//            } else {
//                System.out.println("publised");
//                final JsonObject jsonObject = JsonObject.mapFrom(transaction);
//
//            }
//        }catch (Exception e){
//            System.out.println("Lets handle it");
//        }
//    }
//
    @Incoming("txn-kafka")
    @Outgoing("txn")
    @Broadcast
    public String broadCastMessage(String transaction){
        return String.valueOf(transaction);
    }



}
