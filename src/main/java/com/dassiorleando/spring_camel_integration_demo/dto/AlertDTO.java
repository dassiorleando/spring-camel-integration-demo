package com.dassiorleando.spring_camel_integration_demo.dto;

public class AlertDTO {
    private String operation;
    private String message;

    public AlertDTO() {
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AlertDTO{" +
                "operation=" + operation +
                ", message='" + message + '\'' +
                '}';
    }
}
