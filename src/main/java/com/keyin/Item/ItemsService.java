package com.keyin.Item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ItemsService {

    @Autowired
    private ItemRepository itemsRepository;

    public List<Item> getAllItems() {
        return itemsRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemsRepository.findById(id);
    }

    public Item getItemByName(String name) {
        return itemsRepository.findByName(name);
    }

    public Item saveItem(Item item) {
        return itemsRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemsRepository.deleteById(id);
    }
}
