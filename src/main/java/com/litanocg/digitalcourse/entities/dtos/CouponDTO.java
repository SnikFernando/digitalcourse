package com.litanocg.digitalcourse.entities.dtos;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponDTO {

    @NotBlank(message = "El código del cupón no puede estar vacío")
    @Size(max = 50, message = "El código del cupón no puede tener más de 50 caracteres")
    private String couponCode;

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String couponDescription;

    @NotBlank(message = "El tipo de cupón no puede estar vacío")
    @Size(max = 20, message = "El tipo de cupón no puede tener más de 20 caracteres")
    private String couponType;

    @NotNull(message = "El valor de descuento no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El descuento debe ser un valor positivo")
    private BigDecimal couponDiscountValue;

    @NotNull(message = "La fecha de expiración no puede estar vacía")
    private LocalDateTime expirationDate;

    @DecimalMin(value = "0.0", message = "El monto mínimo de compra debe ser positivo")
    private BigDecimal minPurchaseAmount;

    @DecimalMin(value = "0.0", message = "El descuento máximo debe ser positivo")
    private BigDecimal maxCouponDiscount;

    @Size(max = 20, message = "El estado del cupón no puede tener más de 20 caracteres")
    private String couponStatus;

    @Min(value = 0, message = "El total de usos debe ser un número positivo")
    private Integer totalUses;

    @Min(value = 0, message = "Los usos restantes deben ser un número positivo")
    private Integer usesRemaining;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime statusUpdatedAt;

    @Size(max = 20, message = "El estado del registro no puede tener más de 20 caracteres")
    private String statusRegistry;
}
