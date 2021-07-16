package com.redhat;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@RegisterRestClient
public interface ProcessService {

    @GET
    @Path("/server/containers/financial-crime-processing_1.0.0-SNAPSHOT/images/processes/instances/{processInstanceId}")
    @Produces("application/svg+xml")
    @ClientHeaderParam(name="Authorization", value="Basic cGFtQWRtaW46cmVkaGF0cGFtMSE=")
    String getSvg(@javax.ws.rs.PathParam("processInstanceId") String processInstanceId);

    @GET
    @Path("/server/queries/processes/instances/variables/transactionId")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic cGFtQWRtaW46cmVkaGF0cGFtMSE=")
    String getProcess(@javax.ws.rs.QueryParam("varValue") String txnId);

    @GET
    @Path("/server/containers/financial-crime-processing_1.0.0-SNAPSHOT/processes/instances/{processInstanceId}/variables")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic cGFtQWRtaW46cmVkaGF0cGFtMSE=")
    String getProcessInstanceId(@javax.ws.rs.PathParam("processInstanceId") String processInstanceId);

    @GET
    @Path("/server/queries/tasks/instances/admins")
    @Produces("application/json")
    @ClientHeaderParam(name="Authorization", value="Basic cGFtQWRtaW46cmVkaGF0cGFtMSE=")
    String getTasks();


}
