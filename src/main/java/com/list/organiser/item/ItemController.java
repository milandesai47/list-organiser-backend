package com.list.organiser.item;

import com.list.organiser.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Item> getAllItems(Model model) {
        List allItems = itemService.findAll();
        model.addAllAttributes(allItems);
        return allItems;
    }

    @GetMapping(path = "/count")
    public Long getItemCount() {
        return itemService.count();
    }

    @GetMapping(path = "/{itemId}")
    public Optional<Item> getItemById(@PathVariable("itemId") String itemId) {
        return itemService.fineOne(Long.parseLong(itemId));
    }
    @GetMapping(path = "/categoryId/{categoryId}")
    public List<Item> getItemByCategoryId(@PathVariable("categoryId") long categoryId) {
        return itemService.findItemByCategoryId(categoryId);
    }


}
