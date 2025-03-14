package com.litanocg.digitalcourse.entities.mappers;

import com.litanocg.digitalcourse.entities.Category;
import com.litanocg.digitalcourse.entities.dtos.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDTO(Category category);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusUpdatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "categoryID", ignore = true)
    @Mapping(target = "statusRegistry", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);
}
