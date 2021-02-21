package com.list.organiser.service;

import com.list.organiser.category.Category;
import com.list.organiser.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        Iterable <Category> categories= categoryRepository.findAll();
        List categoryList = new ArrayList<Category>();
        categories.forEach(e -> categoryList.add(e));

        return categoryList;
    }

    public Long count(){
        return categoryRepository.count();
    }

    public Category findOne(Long categoryId) {
        return categoryRepository.findByCategoryId(categoryId);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
