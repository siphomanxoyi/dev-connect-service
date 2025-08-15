package dev.sipho.dev.connect.service.service;

import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        log.info("Registering user ...");
        return null;
    }
}
