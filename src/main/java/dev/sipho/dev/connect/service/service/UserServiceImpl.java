package dev.sipho.dev.connect.service.service;

import dev.sipho.dev.connect.service.dto.user.DevConnectUserDto;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationResponse;
import dev.sipho.dev.connect.service.exception.DevConnectUserException;
import dev.sipho.dev.connect.service.mapper.DevConnectUserMapper;
import dev.sipho.dev.connect.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        var username = request.username();
        var email = request.email();

        assertUsernameAndEmailAvailable(username, email);

        log.debug("Registering user: {}", username);
        var entity = DevConnectUserMapper.toEntity(request);
        userRepository.save(entity);
        return new UserRegistrationResponse(true);
    }

    private void assertUsernameAndEmailAvailable(String username, String email) {
        Map<String, String> errors = new HashMap<>();
        boolean usernameTaken = userRepository.existsByUsername(username);
        boolean emailTaken = userRepository.existsByEmail(email);

        if(usernameTaken) errors.put("username", "Username already taken");
        if(emailTaken) errors.put("email", "Email already taken");

        if(!errors.isEmpty()){
            throw new DevConnectUserException(errors);
        }
    }

    @Override
    public DevConnectUserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(DevConnectUserMapper::toDto)
                .orElseThrow(() -> new DevConnectUserException("User with id: " + id + " cannot be found!"));
    }


}
