package com.litanocg.digitalcourse.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private String courseName;
    private Double coursePrice;
    private Double courseDiscount;
    private String courseDescription;
    private String courseImageURL;




}
