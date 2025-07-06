package com.ntu.flightcoreservice.exception;

import java.util.HashMap;
import java.util.Map;

public class CustomException extends RuntimeException {
    private final int code;
    private final String description;

    public CustomException(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public CustomException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public CustomException(String message, Throwable cause, int code, String description) {
        super(message, cause);
        this.code = code;
        this.description = description;
    }

    public CustomException(Throwable cause, int code, String description) {
        super(cause);
        this.code = code;
        this.description = description;
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code, String description) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.description = description;
    }

    public Map<String, Object> getErrorDetails() {
        Map<String, Object> errorData = new HashMap();
        errorData.put("errorCode", this.code);
        errorData.put("description", this.description);
        return errorData;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}