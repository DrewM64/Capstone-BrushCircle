package com.BrushCircle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;

public class ErrorMessage {
    @JsonProperty("errorCode")
    private String errorCode;
    @JsonProperty("errorDescription")
    private String errorDescription;
    public String getErrorCode(){return this.errorCode;}
    public String getErrorDescription(){return this.errorDescription;}

    @ConstructorProperties({"errorCode", "errorDescription"})
    public ErrorMessage(String errorCode, String errorDescription) {
        this.errorCode=errorCode;
        this.errorDescription=errorDescription;
    }

    public ErrorMessage(){}
}
