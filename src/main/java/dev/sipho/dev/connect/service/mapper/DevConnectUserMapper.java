package dev.sipho.dev.connect.service.mapper;

import dev.sipho.dev.connect.service.dto.user.DevConnectUserDto;
import dev.sipho.dev.connect.service.dto.user.UserRegistrationRequest;
import dev.sipho.dev.connect.service.model.DevConnectUser;

import java.time.LocalDateTime;

public class DevConnectUserMapper {
    private DevConnectUserMapper (){}

    public static DevConnectUserDto toDto(DevConnectUser entity){
        return new DevConnectUserDto(entity.getEmail(), entity.getUsername(), entity.getFirstName(), entity.getLastName());
    }

    public static DevConnectUser toEntity(UserRegistrationRequest request) {
        var now = LocalDateTime.now();

        return new DevConnectUser(
                request.username(),
                request.email(),
                request.password(),
                request.firstName(),
                request.lastName(),
                now
        );

    }
}
