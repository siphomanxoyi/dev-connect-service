package dev.sipho.dev.connect.service.util;

import dev.sipho.dev.connect.service.dto.common.ApiResponse;
import dev.sipho.dev.connect.service.dto.common.ApiStatus;

import java.util.List;

public class ResponseUtil {
    private ResponseUtil () {}

    public static <T> ApiResponse<T> success (T data, String message){
        return new ApiResponse<>(data, ApiStatus.SUCCESS, message, List.of());
    }

    public static <T> ApiResponse<T> failure (T data, String message, List<String> errors ){
        return new ApiResponse<>(data, ApiStatus.ERROR, message, errors);
    }
}
