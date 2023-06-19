package com.list.organiser.organise;

import com.list.organiser.service.CategoryService;
import com.list.organiser.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrganiserServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;

    @Test
    void organisedList() {
    }
}