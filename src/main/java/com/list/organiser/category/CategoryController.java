package com.list.organiser.category;

import com.list.organiser.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping(path = "/count")
    public Long getCategoryCount() {
        return categoryService.count();
    }


    @RequestMapping(path = "/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") String categoryId) {
        return categoryService.findOne(Long.parseLong(categoryId));
    }

//    @PostMapping
//    public void insertCategory(@RequestBody Category category){
//        categoryService.save(category);
//    }

//    @DeleteMapping(path = "/delete/{categoryId}")
//    public void deleteCategory(@PathVariable("categoryId") String categoryId) {
//        categoryService.delete(Long.parseLong(categoryId));
//    }
}
