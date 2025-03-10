package com.litanocg.digitalcourse.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("categories")
public class Category {

    @Id
    @Column("CategoryId")
    private Long categoryID;

    @Column("CategoryName")
    private String categoryName;

    @Column("CategoryDescription")
    private String categoryDescription;

    @Column("CategoryImageUrl")
    private String categoryImageUrl;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;



}
