package dev.sipho.dev.connect.service.service;

import dev.sipho.dev.connect.service.dto.user.DevConnectUserDto;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request);
    DevConnectUserDto getUserById(Long id);
}
