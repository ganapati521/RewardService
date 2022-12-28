package com.rewards.service.exceptions.code;

public enum CommonErrorCode implements ErrorCode {

    INVALID_USER_REQUEST("Invalid user : {0}  Request came", "RMS-1001"), GENERIC_EXCEPTION("Something went wrong. Please contact system admin if error persist ", "RMS-1008"),
    NO_DATA_FOUND("No data found for requested data", "RMS-1002"),INVALID_USER_CREDENTIALS("Invalid user credentials","UMS-1003"), CUSTOMER_ID_INVALID("Customer id : {0} is invalid","RMS-1004" ),CUSTOMER_ID_MISSING("Customer id is missing in request","RMS-1003" );

    private String errorCode;
    private String errorMessage;

    private CommonErrorCode(String errorMessage, String errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
