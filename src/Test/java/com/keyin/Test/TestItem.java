package com.keyin.Test;

import com.keyin.Item.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class TestItem {

    @Test
    public void testGetId() {
        Item item = new Item();
        item.setId(1L);
        assertEquals(1L, item.getId());
    }

    @Test
    public void testGetName() {
        Item item = new Item();
        item.setName("Item 1");
        assertEquals("Item 1", item.getName());
    }

}
