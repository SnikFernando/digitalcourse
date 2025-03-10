package com.litanocg.digitalcourse.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("purchases")
public class Purchase {

    @Id
    @Column("PurchaseID")
    private Long purchaseID;

    @Column("UserID")
    private Long userID;

    @Column("TotalPurchaseAmount")
    private BigDecimal totalPurchaseAmount;

    @Column("DiscountTotal")
    private BigDecimal discountTotal;

    @Column("PaymentMethod")
    private String paymentMethod;

    @Column("Currency")
    private String currency;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
