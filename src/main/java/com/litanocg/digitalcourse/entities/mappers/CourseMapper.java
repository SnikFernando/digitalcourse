package com.litanocg.digitalcourse.entities.mappers;

import com.litanocg.digitalcourse.entities.Course;
import com.litanocg.digitalcourse.entities.dtos.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDTO(Course course);
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusUpdatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusRegistry", ignore = true)
    @Mapping(target = "courseID", ignore = true)
    Course toEntity(CourseDTO courseDTO);

    @Mapping(target = "createdAt", ignore = true) // No modificar createdAt
    void updateCourseFromDTO(CourseDTO courseDTO, @MappingTarget Course course);

}
