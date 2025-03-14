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
@Table("coupons")
public class Coupon {

    @Id
    @Column ("CouponID")
    private Long couponID;

    @Column ("CouponCode")
    private String couponCode;

    @Column("CouponDescription")
    private String couponDescription;

    @Column("CouponType")
    private String couponType;

    @Column("CouponDiscountValue")
    private BigDecimal couponDiscountValue;

    @Column("ExpirationDate")
    private LocalDateTime expirationDate;

    @Column("MinPurchaseAmount")
    private BigDecimal minPurchaseAmount;

    @Column("MaxCouponDiscount")
    private BigDecimal maxCouponDiscount;

    @Column("CouponStatus")
    private String couponStatus;

    @Column("TotalUses")
    private Integer totalUses;

    @Column("UsesRemaining")
    private Integer usesRemaining;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;

}
