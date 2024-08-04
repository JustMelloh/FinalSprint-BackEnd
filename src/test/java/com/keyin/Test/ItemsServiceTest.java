package com.keyin.Test;

import com.keyin.Item.Item;
import com.keyin.Item.ItemRepository;
import com.keyin.Item.ItemsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ItemsServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemsService itemsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllItems() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("Item1");

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("Item2");

        when(itemRepository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<Item> items = itemsService.getAllItems();
        assertEquals(2, items.size());
        assertEquals("Item1", items.get(0).getName());
        assertEquals("Item2", items.get(1).getName());
    }

    @Test
    public void testGetItemById() {
        Item item = new Item();
        item.setId(1L);
        item.setName("Item1");

        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

        Optional<Item> foundItem = itemsService.getItemById(1L);
        assertTrue(foundItem.isPresent());
        assertEquals("Item1", foundItem.get().getName());
    }

    @Test
    public void testSaveItem() {
        Item item = new Item();
        item.setId(1L);
        item.setName("Item1");

        when(itemRepository.save(item)).thenReturn(item);

        Item savedItem = itemsService.saveItem(item);
        assertEquals("Item1", savedItem.getName());
    }

    @Test
    public void testDeleteItem() {
        itemsService.deleteItem(1L);
        verify(itemRepository, times(1)).deleteById(1L);
    }
}