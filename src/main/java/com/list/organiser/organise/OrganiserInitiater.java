package com.list.organiser.organise;

import com.list.organiser.category.Category;
import com.list.organiser.item.Item;
import com.list.organiser.service.CategoryService;
import com.list.organiser.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("api/organise")
public class OrganiserInitiater {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    List<String> items = new ArrayList<String>();

    public List<String> getItems() {
        items.add("apple");
        items.add("beef");
        items.add("butter");
        items.add("chicken");
        items.add("beans");
        items.add("cheese");
        items.add("orange");
        items.add("tomatoes");
        items.add("spinach");
        return items;
    }

    @RequestMapping(path = "/organiser", method = RequestMethod.GET)
    public List<String> getOrganisedList() {
        List<String> unorganisedList = getItems();
        List<String> organisedItemList = new ArrayList<>();
        List<Item> organisedList = new ArrayList<Item>(unorganisedList.size());
        System.out.println("before organise");
        for(String item : unorganisedList){
            Item foundItem = (Item) itemService.findItemByItemName(item);
            Category belogsToCategory = categoryService.findOne(foundItem.getCategoryId());
            System.out.println("item : " + foundItem.getItemName() + ", category : " + belogsToCategory.getCategoryName() + ", id : " + belogsToCategory.getCategoryId());
            organisedList.add(foundItem);
        }

        Collections.sort(organisedList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int) (o1.getCategoryId() - o2.getCategoryId());
            }
        });
        System.out.println("after organise");
        for(Item item : organisedList){
            System.out.println("item : " + item.getItemName() + ", category id : " + item.getCategoryId());
            organisedItemList.add(item.getItemName());
        }
        return organisedItemList;
    }
}
