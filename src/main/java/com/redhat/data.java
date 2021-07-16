package com.redhat;

import java.io.Serializable;

public class data implements Serializable {
    static final long serialVersionUID = 1L;

    private java.lang.Integer transactionId;
    private java.lang.Integer transactionAmount;
    private java.lang.String transactionCountry;
    private java.lang.String merchantType;
    private Double customerRiskIndex;
    private java.lang.Boolean cityChange;
    private java.lang.Boolean marriage;
    private java.lang.Boolean jobChange;
    private java.lang.Integer averageTransactionAmount;
    private java.lang.String fraudAlert;
    private java.lang.String amlAlert;

    public data() {
    }

    public java.lang.Integer getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(java.lang.Integer transactionId) {
        this.transactionId = transactionId;
    }

    public java.lang.Integer getTransactionAmount() {
        return this.transactionAmount;
    }

    public void setTransactionAmount(java.lang.Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public java.lang.String getTransactionCountry() {
        return this.transactionCountry;
    }

    public void setTransactionCountry(java.lang.String transactionCountry) {
        this.transactionCountry = transactionCountry;
    }

    public java.lang.String getMerchantType() {
        return this.merchantType;
    }

    public void setMerchantType(java.lang.String merchantType) {
        this.merchantType = merchantType;
    }

    public java.lang.Boolean getCityChange() {
        return this.cityChange;
    }

    public void setCityChange(java.lang.Boolean cityChange) {
        this.cityChange = cityChange;
    }

    public java.lang.Boolean getMarriage() {
        return this.marriage;
    }

    public void setMarriage(java.lang.Boolean marriage) {
        this.marriage = marriage;
    }

    public java.lang.Boolean getJobChange() {
        return this.jobChange;
    }

    public void setJobChange(java.lang.Boolean jobChange) {
        this.jobChange = jobChange;
    }

    public java.lang.Integer getAverageTransactionAmount() {
        return this.averageTransactionAmount;
    }

    public void setAverageTransactionAmount(
            java.lang.Integer averageTransactionAmount) {
        this.averageTransactionAmount = averageTransactionAmount;
    }

    public java.lang.String getFraudAlert() {
        return this.fraudAlert;
    }

    public void setFraudAlert(java.lang.String fraudAlert) {
        this.fraudAlert = fraudAlert;
    }

    public java.lang.String getAmlAlert() {
        return this.amlAlert;
    }

    public void setAmlAlert(java.lang.String amlAlert) {
        this.amlAlert = amlAlert;
    }

    public java.lang.Double getCustomerRiskIndex() {
        return this.customerRiskIndex;
    }

    public void setCustomerRiskIndex(java.lang.Double customerRiskIndex) {
        this.customerRiskIndex = customerRiskIndex;
    }

    public data(java.lang.Integer transactionId,
                java.lang.Integer transactionAmount,
                java.lang.String transactionCountry, java.lang.String merchantType,
                java.lang.Double customerRiskIndex, java.lang.Boolean cityChange,
                java.lang.Boolean marriage, java.lang.Boolean jobChange,
                java.lang.Integer averageTransactionAmount,
                java.lang.String fraudAlert, java.lang.String amlAlert) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionCountry = transactionCountry;
        this.merchantType = merchantType;
        this.customerRiskIndex = customerRiskIndex;
        this.cityChange = cityChange;
        this.marriage = marriage;
        this.jobChange = jobChange;
        this.averageTransactionAmount = averageTransactionAmount;
        this.fraudAlert = fraudAlert;
        this.amlAlert = amlAlert;
    }

}