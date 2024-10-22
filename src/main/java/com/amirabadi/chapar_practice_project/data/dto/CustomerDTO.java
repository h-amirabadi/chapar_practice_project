package com.amirabadi.chapar_practice_project.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private UUID id;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 100)
    private String firstname;

    @NotNull
    @Size(max = 100)
    private String lastname;

    @Size(max = 500)
    private String description;
}
