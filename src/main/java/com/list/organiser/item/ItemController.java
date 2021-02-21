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

//    @RequestMapping(path = "/home", method = RequestMethod.GET)
//    public Model getAllItemsHtml(Model model) {
//        List allItems = itemService.findAll();
//        for(int i=0; i<= allItems.size(); i++){
//            model.addAttribute("item", allItems.get(0));
//        }
//        return model;
//    }

    @GetMapping(path = "/count")
    public Long getItemCount() {
        return itemService.count();
    }

    @RequestMapping(path = "/{itemId}")
    public Optional<Item> getItemById(@PathVariable("itemId") String itemId) {
        return itemService.fineOne(Long.parseLong(itemId));
    }

    @RequestMapping(path = "/categoryId/{categoryId}")
    public List<Item> getItemByCategoryId(@PathVariable("categoryId") int categoryId) {
        return itemService.findItemByCategoryId(new Long(categoryId));
    }

//    @RequestMapping(path = "/categoryName/{categoryName}")
//    public List<Item> getItemByCategoryName(@PathVariable("categoryName") String categoryName) {
//        return itemService.findItemByCategoryName(categoryName);
//    }

    @PostMapping
    public void insertCategory(@RequestBody Item item){
        itemService.save(item);
    }

    @DeleteMapping(path = "/delete/{itemId}")
    public void deleteCategory(@PathVariable("itemId") String itemId) {
        itemService.delete(Long.parseLong(itemId));
    }

}
