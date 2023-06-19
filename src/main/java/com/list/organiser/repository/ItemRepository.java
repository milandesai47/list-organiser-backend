package com.list.organiser.repository;

import com.list.organiser.item.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "select * from ITEM where CATEGORY_ID = :categoryId", nativeQuery = true)
    Iterable<Item> findItemsByCategoryId(Long categoryId);

    @Query(value = "select * from ITEM where ITEM_NAME = :item_name", nativeQuery = true)
    Item findItemsByItemName(String item_name);


}
