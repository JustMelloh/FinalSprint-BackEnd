package com.keyin.Test;

import com.keyin.Item.Item;
import com.keyin.Villager.Villager;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VillagerTest {

    @Test
    public void testGetId() {
        Villager villager = new Villager();
        villager.setId(1L);
        assertEquals(1L, villager.getId());
    }

    @Test
    public void testGetName() {
        Villager villager = new Villager();
        villager.setName("Villager 1");
        assertEquals("Villager 1", villager.getName());
    }

    @Test
    public void testGetLikes() {
        Villager villager = new Villager();
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        List<Item> likes = Arrays.asList(item1, item2);
        villager.setLikes(likes);
        assertEquals(likes, villager.getLikes());
    }

    @Test
    public void testGetDislikes() {
        Villager villager = new Villager();
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        List<Item> dislikes = Arrays.asList(item1, item2);
        villager.setDislikes(dislikes);
        assertEquals(dislikes, villager.getDislikes());
    }

    @Test
    public void testGetLoves() {
        Villager villager = new Villager();
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        List<Item> loves = Arrays.asList(item1, item2);
        villager.setLoves(loves);
        assertEquals(loves, villager.getLoves());
    }
}