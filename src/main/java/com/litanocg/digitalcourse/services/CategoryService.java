package com.litanocg.digitalcourse.services;

import com.litanocg.digitalcourse.entities.Category;
import com.litanocg.digitalcourse.entities.dtos.CategoryDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.entities.mappers.CategoryMapper;
import com.litanocg.digitalcourse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public Flux<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().map(categoryMapper::toDTO);
    }

    public Mono<CategoryDTO> getCategoryById(Long id){
        return categoryRepository.findById(id).map(categoryMapper::toDTO);
    }

    public Mono<CategoryDTO> createCategory(CategoryDTO categoryDTO){
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryRepository.save(category)
                .map(categoryMapper::toDTO);
    }

    public Mono<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO){
        return categoryRepository.findById(id)
                .flatMap(existingCategory -> {
                    existingCategory.setCategoryName(categoryDTO.getCategoryName());
                    existingCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
                    existingCategory.setCategoryImageUrl(categoryDTO.getCategoryImageUrl());
                    existingCategory.setStatusRegistry(categoryDTO.getStatusRegistry());
                    existingCategory.setStatusUpdatedAt(categoryDTO.getStatusUpdatedAt());
                    return categoryRepository.save(existingCategory)
                            .map(categoryMapper::toDTO);
                });
    }

    public Mono<MessageResponse> deleteCategory(Long id) {
        return categoryRepository.findById(id)
                .flatMap(category ->
                        categoryRepository.delete(category)
                                .thenReturn(new MessageResponse("La categoría fue eliminada correctamente"))
                )
                .switchIfEmpty(Mono.defer(() -> Mono.just(new MessageResponse("La categoría con ID " + id + " no existe"))));
    }
}
