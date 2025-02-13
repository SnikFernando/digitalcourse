package com.litanocg.digitalcourse.entities.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    private String firstName;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 120, message = "El nombre debe tener entre 2 y 120 caracteres")
    private String lastName;
    @NotNull(message = "El tipo de documento no puede estar vacío")
    @Min(value = 1, message = "El tipo de documento debe ser un número válido")
    private Long documentTypeID;
    @NotBlank(message = "El numero de documento no puede estar vacío")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$", message = "El número de documento debe tener entre 8 y 15 caracteres alfanuméricos")
    private String documentNumber;
    @NotBlank(message = "El email no puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El formato del email no es válido")
    private String userEmail;
    private String userImageUrl;
    private Boolean emailVerified;
    @NotBlank(message = "El password no puede estar vacío")
    @Size(min = 8, max = 20, message = "El password debe tener entre 8 y 20 caracteres")
    private String password;
}
