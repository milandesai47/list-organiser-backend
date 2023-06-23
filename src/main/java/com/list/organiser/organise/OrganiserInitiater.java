package com.list.organiser.organise;

import com.list.organiser.item.Item;
import com.list.organiser.item.ItemsWrapper;
import com.list.organiser.service.CategoryService;
import com.list.organiser.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class OrganiserInitiater {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @Autowired OrganiserService organiserService;

    List<String> items = new ArrayList<String>();


    public ItemsWrapper getItems() {
        items.add("apple");
        items.add("beef");
        items.add("butter");
        items.add("chicken");
        items.add("beans");
        items.add("cheese");
        items.add("orange");
        items.add("tomatoes");
        items.add("spinach");
        return new ItemsWrapper(items);
    }

    @RequestMapping(path = "/organiseNice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrganisedList2() {
        List<String> unorganisedList = getItems().getItems();
        Map<String, List<String>> organisedOne = organiserService.organisedList(unorganisedList);

        System.out.println(organisedOne.toString());
        return new ResponseEntity<>(organisedOne.toString(), HttpStatus.OK);
    }
    @PostMapping(value = "/organize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> organizeShoppingList(@RequestBody ItemsWrapper items) {
        Map<String, List<String>> organisedJson = organiserService.organisedList(items.getItems());
        if (organisedJson != null) {
            return new ResponseEntity<>(organisedJson.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
    
}
