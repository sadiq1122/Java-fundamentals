package com.example.splitwise.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    @NotBlank
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String phoneNo;
}
