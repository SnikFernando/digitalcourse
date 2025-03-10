package com.litanocg.digitalcourse.repositories;

import com.litanocg.digitalcourse.entities.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}
