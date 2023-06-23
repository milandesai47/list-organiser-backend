package com.list.organiser.organise;


import com.list.organiser.category.Category;
import com.list.organiser.service.CategoryService;
import com.list.organiser.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganiserService {

    private final CategoryService categoryService;

    private final ItemService itemService;

    public OrganiserService(CategoryService categoryService, ItemService itemService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    public Map<String, List<String>> organisedList(List<String> items) {
        Map<String, List<String>> organizedList = new HashMap<>();
        for (String item : items) {
            // Extract the category name from the item (assuming it follows a specific format)
            Category category = extractCategoryName(item);
            if (category == null) {
                category = categoryService.findCategoryByName("other");
            }

            // Get the list of items for the current category
            List<String> categoryItems = organizedList.get(category.getCategoryName());

            // If the category is not in the map, create a new list for it
            if (categoryItems == null || categoryItems.isEmpty()) {
                categoryItems = new ArrayList<>();
                organizedList.put(category.getCategoryName(), categoryItems);
            }

            // Add the item to the list for the current category
            categoryItems.add(item);
        }
        return organizedList;
    }


    private Category extractCategoryName(String item) {
        return categoryService.findOne(itemService.findItemByItemName(item).getCategoryId().getCategoryId());
    }

}
