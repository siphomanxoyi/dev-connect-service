package dev.sipho.dev.connect.service.controller;

import dev.sipho.dev.connect.service.service.UserService;
import dev.sipho.dev.connect.service.dto.common.ApiResponse;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationResponse;
import dev.sipho.dev.connect.service.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ApiResponse<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest request) {
        var response = userService.registerUser(request);
        return ResponseUtil.success(response, "Successfully registered user");
    }
}
