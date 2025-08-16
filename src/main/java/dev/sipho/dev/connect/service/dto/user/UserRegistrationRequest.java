package dev.sipho.dev.connect.service.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationRequest(
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Please enter a valid email")
        String email,
        @NotBlank(message = "Username cannot be blank, empty or null")
        String username,
        @NotBlank(message = "Password cannot be blank, empty or null")
        String password,
        @NotBlank(message = "First name cannot be blank, empty or null")
        String firstName,
        @NotBlank(message = "Last name cannot be blank, empty or null")
        String lastName) {
}
