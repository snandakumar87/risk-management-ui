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
import java.nio.charset.StandardCharsets;
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
        Map map = (Map) processList.get(0);

        System.out.println(String.valueOf(map.get("process-instance-id")));

        String svg = processService.getSvg(String.valueOf(map.get("process-instance-id")));

        Map processVarMap=new ObjectMapper().readValue(processService.getProcessInstanceId(String.valueOf(map.get("process-instance-id"))), HashMap.class);

        String varMa = (String) processVarMap.get("data");

        ProcessUIObject processUIObject = new ProcessUIObject();
        processUIObject.setProcessVariables(new ObjectMapper().readValue(varMa,Map.class));
        System.out.println(map.get("process-instance-id"));
        processUIObject.setProcessId(map.get("process-instance-id")+"");
        processUIObject.setSvg(svg);


        return processUIObject;
    }


    @GET
    @Path("/processdata/{processId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessUIObject getProcessVariables(@PathParam("processId") String processId) throws JsonProcessingException {
        ProcessUIObject processUIObject = new ProcessUIObject();
        Map processVarMap=new ObjectMapper().readValue(processService.getProcessInstanceId(processId), HashMap.class);

        String varMa = (String) processVarMap.get("data");
        processUIObject.setProcessVariables(new ObjectMapper().readValue(varMa,Map.class));
        return processUIObject;
    }

    @GET
    @Path("/decisionnodedata/{processId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessUIObject getDecisionNodeData(@PathParam("processId") String processId) throws JsonProcessingException {
        ProcessUIObject processUIObject = new ProcessUIObject();
        Map processVarMap=new ObjectMapper().readValue(processService.getProcessInstanceId(processId), HashMap.class);

        String varMa = (String) processVarMap.get("data");

        Map<String,String> decisionNodeMap = new HashMap<>();
        decisionNodeMap.put("thresholdCalculation", (String) processVarMap.get("thresholdCalculation"));
        decisionNodeMap.put("limit", String.valueOf(processVarMap.get("limit")));


        processUIObject.setProcessVariables(decisionNodeMap);
        return processUIObject;
    }

    @GET
    @Path("/tasks/{processId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessUIObject getTasks(@PathParam("processId") String processId) throws JsonProcessingException {
       ProcessUIObject processUIObject = new ProcessUIObject();
        List<TaskInstance> taskInstances = new ArrayList<>();

        TaskInstance taskInstance;
        Map taskListObj = new ObjectMapper().readValue(processService.getTasks(processId),Map.class);
        List<Map> taskList = (List<Map>) taskListObj.get("task-summary");
        System.out.println(taskList);
        System.out.println(processId);

        for(Map taskMapObj: taskList) {

            if(String.valueOf(taskMapObj.get("task-proc-inst-id")).equals(processId)){
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

    @GET
    @Path("/processes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcessDefinition> getProcesses() throws JsonProcessingException {
        ProcessDefinition processUIObject = null;
        List<ProcessDefinition> response = new ArrayList<>();

        Map process = new ObjectMapper().readValue(processService.getProcesses("VarBreachCheckWorkflow"),Map.class);

        List<Map> processList = (List) process.get("process-instance");

        for(Map map: processList) {
            processUIObject = new ProcessDefinition();
            Map processVarMap=new ObjectMapper().readValue(processService.getProcessInstanceId(map.get("process-instance-id").toString()), HashMap.class);
            String varMa = (String) processVarMap.get("data");
            Map varMap = new ObjectMapper().readValue(varMa,Map.class);
            processUIObject.setCorrelationId((String) varMap.get("correlationId"));
            processUIObject.setSubProcessCorrelationId(varMap.get("subProcessCorrelationId").toString());
            processUIObject.setEntityId((String) varMap.get("entityId"));
            processUIObject.setEntityType((String) varMap.get("entityType"));
            response.add(processUIObject);

        }

        return response;
    }

    
}