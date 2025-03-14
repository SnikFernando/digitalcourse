package com.litanocg.digitalcourse.repositories;

import com.litanocg.digitalcourse.entities.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {
}
