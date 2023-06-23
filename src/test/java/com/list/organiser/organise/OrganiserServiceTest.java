package com.list.organiser.organise;

import com.list.organiser.category.Category;
import com.list.organiser.item.Item;
import com.list.organiser.repository.CategoryRepository;
import com.list.organiser.repository.ItemRepository;
import com.list.organiser.service.CategoryService;
import com.list.organiser.service.ItemService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
class OrganiserServiceTest {

    private CategoryService categoryService;

    @MockBean
    private ItemService itemService;
//
//    @Autowired
//    ItemRepository itemRepository;
//
//    @Autowired
//    CategoryRepository categoryRepository;

    private OrganiserService organiserService;


    @BeforeEach
    void initUseCase() {
        categoryService = new CategoryService();
        itemService = new ItemService();
        organiserService = new OrganiserService(categoryService, itemService);
    }
    @Before
    public void setUp() throws Exception {
        Category veg = new Category("veg");
        Category meat = new Category("meat");
        List<Category> mockCategory = Arrays.asList(veg,meat);
        when(categoryService.findAll()).thenReturn(mockCategory);

        List<Item> mockItems = Arrays.asList(new Item(veg, "spinach"),
                                            new Item(meat,"beef"),
                                            new Item(veg,"carrot"),
                                            new Item(meat,"chicken")
        );

        when(itemService.findAll()).thenReturn(mockItems);
    }

    @Test
    void organisedList() {
        List<String> items = Arrays.asList("beef", "carrot", "chicken", "sprinach");
        Map<String, List<String>> stringListMap = organiserService.organisedList(items);

        System.out.println(stringListMap);
    }
}