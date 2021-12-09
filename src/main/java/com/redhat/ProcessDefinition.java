package com.redhat;

public class ProcessDefinition {
    String correlationId;
    String subProcessCorrelationId;
    String entityType;
    String entityId;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getSubProcessCorrelationId() {
        return subProcessCorrelationId;
    }

    public void setSubProcessCorrelationId(String subProcessCorrelationId) {
        this.subProcessCorrelationId = subProcessCorrelationId;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
