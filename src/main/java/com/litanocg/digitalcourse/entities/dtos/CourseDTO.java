package com.litanocg.digitalcourse.entities.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    @Size(min = 2, max = 255, message = "El nombre del curso debe tener entre 2 y 255 caracteres")
    private String courseName;

    @NotNull(message = "El precio del curso no puede estar vacío")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio del curso debe ser mayor a 0")
    private BigDecimal coursePrice;

    @NotNull(message = "El descuento del curso no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El descuento no puede ser negativo")
    private BigDecimal courseDiscount;

    @NotBlank(message = "La descripción del curso no puede estar vacía")
    @Size(min = 10, max = 2000, message = "La descripción debe tener entre 10 y 2000 caracteres")
    private String courseDescription;

    @NotNull(message = "La categoría del curso no puede estar vacía")
    private Long categoryID;

    private String courseImageUrl;

    @NotBlank(message = "El estado del curso no puede estar vacío")
    private String statusRegistry;

}
