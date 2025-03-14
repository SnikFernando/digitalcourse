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
@Table("courses")
public class Course {

    @Id
    @Column("CourseID")
    private Long courseID;

    @Column("CourseName")
    private String courseName;

    @Column("CoursePrice")
    private BigDecimal coursePrice;

    @Column("CourseDiscount")
    private BigDecimal courseDiscount;

    @Column("CourseDescription")
    private String courseDescription;

    @Column("CategoryID")
    private Long categoryID;

    @Column("CourseImageUrl")
    private String courseImageUrl;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
