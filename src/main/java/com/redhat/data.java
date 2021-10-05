package com.redhat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class data implements Serializable {
    static final long serialVersionUID = 1L;

    private java.lang.String entityType;
    private java.lang.String entityId;
    private java.lang.Boolean allAccounts;

    private java.lang.Double confidence;

    private java.lang.String correlationId;

    private java.lang.String subProcessCorrelationId;

    public data() {
    }

    private String id;
    private Double valueAtRisk;
    private LocalDateTime valueAtRiskAsOf;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Boolean getAllAccounts() {
        return allAccounts;
    }

    public void setAllAccounts(Boolean allAccounts) {
        this.allAccounts = allAccounts;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValueAtRisk() {
        return valueAtRisk;
    }

    public void setValueAtRisk(Double valueAtRisk) {
        this.valueAtRisk = valueAtRisk;
    }

    public LocalDateTime getValueAtRiskAsOf() {
        return valueAtRiskAsOf;
    }

    public void setValueAtRiskAsOf(LocalDateTime valueAtRiskAsOf) {
        this.valueAtRiskAsOf = valueAtRiskAsOf;
    }
}