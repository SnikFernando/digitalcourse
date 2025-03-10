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
@Table("purchaseItems")
public class PurchaseItem {

    @Id
    @Column("PurchaseItemID")
    private Long purchaseItemID;

    @Column("PurchaseID")
    private Long purchaseID;

    @Column("CourseID")
    private Long courseID;

    @Column("CouponID")
    private Long couponID;

    @Column("ItemQuantity")
    private Integer itemQuantity;

    @Column("ItemUnitPrice")
    private BigDecimal itemUnitPrice;

    @Column("CouponAmount")
    private BigDecimal couponAmount;

    @Column("DiscountAmount")
    private BigDecimal discountAmount;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
