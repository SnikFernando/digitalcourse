package com.litanocg.digitalcourse.controllers;
import com.litanocg.digitalcourse.entities.dtos.CategoryDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Validated
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Flux<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Mono<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Mono<CategoryDTO> createdCategory(@Validated @RequestBody CategoryDTO category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Mono<CategoryDTO> updatedCategory(@PathVariable Long id, @Validated @RequestBody CategoryDTO category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<MessageResponse>> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id)
                .map(response -> {
                    if (response.getMessage().contains("no existe")) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                    }
                    return ResponseEntity.ok(response);
                });
    }

}
