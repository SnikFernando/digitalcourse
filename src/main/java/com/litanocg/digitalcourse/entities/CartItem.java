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
@Table("cartitems")
public class CartItem {

    @Id
    @Column("CartItemID")
    private Long cartItemID;

    @Column("CartID")
    private Long cartID;

    @Column("CourseID")
    private Long courseID;

    @Column("ItemQuantity")
    private Integer itemQuantity;

    @Column("ItemUnitPrice")
    private BigDecimal itemUnitPrice;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
