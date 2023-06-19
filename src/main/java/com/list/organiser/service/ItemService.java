package com.list.organiser.service;

import com.list.organiser.item.Item;
import com.list.organiser.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll(){
        Iterable<Item> items = itemRepository.findAll();

        List itemList = new ArrayList<Item>();
        items.forEach(e -> itemList.add(e));

        return itemList;
    }

    public Long count(){
        return itemRepository.count();
    }

    public Optional<Item> fineOne(Long itemId) {
        return itemRepository.findById(itemId);
    }

    public List<Item> findItemByCategoryId(Long categoryId) {
        Iterable<Item> items = itemRepository.findItemsByCategoryId(categoryId);

        List itemList = new ArrayList<Item>();
        items.forEach(e -> itemList.add(e));

        return itemList;
    }

    public Item findItemByItemName(String itemName) {
        return itemRepository.findItemsByItemName(itemName);
    }


}
