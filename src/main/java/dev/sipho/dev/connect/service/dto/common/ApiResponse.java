package dev.sipho.dev.connect.service.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse <T> {
    private T data;
    private ApiStatus apiStatus;
    private String message;
    private Map<String, String> errors;
}
