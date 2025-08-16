package dev.sipho.dev.connect.service.controller;

import dev.sipho.dev.connect.service.dto.user.DevConnectUserDto;
import dev.sipho.dev.connect.service.service.UserService;
import dev.sipho.dev.connect.service.dto.common.ApiResponse;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationResponse;
import dev.sipho.dev.connect.service.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserRegistrationResponse>> registerUser(@Valid @RequestBody UserRegistrationRequest request) {
        var response = userService.registerUser(request);
        var uri = URI.create("/user/"); // To update with actual uri uri
        return ResponseEntity
                .created(uri)
                .body(ResponseUtil.success(response, "Successfully registered user"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DevConnectUserDto>> getUserById(@PathVariable Long userId) {
        var response = userService.getUserById(userId);
        return ResponseEntity.ok(ResponseUtil.success(response, "Successfully retrieved user"));
    }
}
