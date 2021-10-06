package com.redhat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Multi;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.eventbus.EventBus;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/transaction")
public class TransactionResource {

    @Inject
    @RestClient
    ProcessService processService;


    @Inject
    @Channel("txn")
    Publisher<String> transactionPublisher;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.TEXT_PLAIN)
    public Publisher<String> stream()
    {
        System.out.println("here");


        return transactionPublisher;
    }

    @GET
    @Path("/svg/{txnId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessUIObject getSvg(@PathParam("txnId") Long txnId) throws JsonProcessingException {
        System.out.println("came here"+txnId);
        String response = processService.getProcess(String.valueOf(txnId),1,2);
        System.out.println(response);

        Map responseObj = new ObjectMapper().readValue(response,Map.class);
        List processList = (List) responseObj.get("process-instance");
        Map<String,String> map = (Map<String, String>) processList.get(0);

        System.out.println(String.valueOf(map.get("process-instance-id")));

        String svg = processService.getSvg(String.valueOf(map.get("process-instance-id")));

        Map processVarMap=new ObjectMapper().readValue(processService.getProcessInstanceId(String.valueOf(map.get("process-instance-id"))), HashMap.class);

        String varMa = (String) processVarMap.get("data");

        ProcessUIObject processUIObject = new ProcessUIObject();
        processUIObject.setProcessVariables(new ObjectMapper().readValue(varMa,Map.class));
        processUIObject.setSvg(svg);

        List<TaskInstance> taskInstances = new ArrayList<>();

        TaskInstance taskInstance;

        String processInstanceId = String.valueOf(map.get("process-instance-id"));

        Map taskListObj = new ObjectMapper().readValue(processService.getTasks(),Map.class);
        List<Map> taskList = (List<Map>) taskListObj.get("task-summary");
        System.out.println(taskList);
        System.out.println(processInstanceId);

        for(Map taskMapObj: taskList) {

            if(String.valueOf(taskMapObj.get("task-proc-inst-id")).equals(processInstanceId)){
                taskInstance = new TaskInstance();
                taskInstance.setTaskId(String.valueOf(taskMapObj.get("task-id")));
                taskInstance.setTaskName((String) taskMapObj.get("task-name"));
                taskInstance.setStatus((String) taskMapObj.get("task-status"));
                taskInstance.setOwner((String) taskMapObj.get("task-actual-owner"));
                taskInstances.add(taskInstance);
            }
        }
        processUIObject.setTaskList(taskInstances);


        return processUIObject;
    }




    
}