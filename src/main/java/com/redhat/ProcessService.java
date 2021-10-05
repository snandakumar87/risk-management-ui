package com.redhat;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@RegisterRestClient
public interface ProcessService {

    @GET
    @Path("/server/containers/risk-analytics-orchestrator_1.0.0-SNAPSHOT/images/processes/instances/{processInstanceId}")
    @Produces("application/svg+xml")
    @ClientHeaderParam(name="Authorization", value="Basic YWRtaW5Vc2VyOlJlZEhhdA==")
    String getSvg(@javax.ws.rs.PathParam("processInstanceId") String processInstanceId);

    @GET
    @Path("/server/queries/processes/instances/variables/subProcessCorrelationId")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic YWRtaW5Vc2VyOlJlZEhhdA==")
    String getProcess(@javax.ws.rs.QueryParam("varValue") String txnId);

    @GET
    @Path("/server/containers/risk-analytics-orchestrator_1.0.0-SNAPSHOT/processes/instances/{processInstanceId}/variables")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic YWRtaW5Vc2VyOlJlZEhhdA==")
    String getProcessInstanceId(@javax.ws.rs.PathParam("processInstanceId") String processInstanceId);

    @GET
    @Path("/server/queries/tasks/instances/admins")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic YWRtaW5Vc2VyOlJlZEhhdA==")
    String getTasks();


}
