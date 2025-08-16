package dev.sipho.dev.connect.service.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DevConnectUserException extends RuntimeException {
    public static final String DEFAULT_DEV_CONNECT_ERROR_MSG = "Something went wrong saving user!";
    private Map<String, String> errors;

    public DevConnectUserException(String message, Map<String, String> errors){
        super(message);
        errors.put("error", message);
    }

    public DevConnectUserException(String message) {
        super(message);
        errors = new HashMap<>();
        errors.put("error", message);
    }

    public DevConnectUserException(Map<String, String> errors) {
        super(DEFAULT_DEV_CONNECT_ERROR_MSG);
        this.errors = errors;
    }
}
