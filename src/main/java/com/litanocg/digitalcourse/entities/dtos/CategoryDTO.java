package com.litanocg.digitalcourse.entities.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre de la categoría debe tener entre 2 y 100 caracteres")
    private String categoryName;

    @NotBlank(message = "La descripción de la categoría no puede estar vacía")
    @Size(min = 10, max = 300, message = "La descripción debe tener entre 10 y 300 caracteres")
    private String categoryDescription;
    private String categoryImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String statusRegistry;
    private LocalDateTime statusUpdatedAt;

}
