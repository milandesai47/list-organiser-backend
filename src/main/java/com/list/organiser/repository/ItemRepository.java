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

//    @Query(value = "SELECT I.ITEM_ID, ITEM_NAME, C.CATEGORY_NAME FROM ITEM I JOIN CATEGORY C WHERE I.CATEGORY_ID = C.CATEGORY_ID AND C.CATEGORY_NAME = :category_name", nativeQuery = true)
//    Iterable<Item> findItemsByCategoryName(String categoryName);

}
