package com.list.organiser.repository;

import com.list.organiser.category.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query(value ="select * from CATEGORY where category_id = :categoryId", nativeQuery = true)
    Category findByCategoryId(Long categoryId);

    Category findCategoryByCategoryName(String categoryName);
}
