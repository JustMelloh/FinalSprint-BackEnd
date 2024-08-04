package com.keyin.Villager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyin.Item.Item;
import com.keyin.Item.ItemRepository;
import com.keyin.Item.ItemsService;

@Service
public class VillagerService {
    @Autowired
    private VillagerRepository villagerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemsService itemsService;

    public Villager getVillagerByName(String name) {
        return villagerRepository.findByName(name);
    }

    public Villager saveVillager(Villager villager) {
        return villagerRepository.save(villager);
    }

    public void deleteVillager(Villager villager) {
        villagerRepository.delete(villager);
    }

    public void deleteVillagerByName(String name) {
        Villager villager = villagerRepository.findByName(name);
        villagerRepository.delete(villager);
    }

    public Villager updateVillager(Villager villager) {
        return villagerRepository.save(villager);
    }

    public Villager getVillagerById(Long id) {
        return villagerRepository.findById(id).orElse(null);
    }

    public Iterable<Villager> getAllVillagers() {
        return villagerRepository.findAll();
    }

    public List<Item> getVillagerLoves(Villager villager) {
        return villager.getLoves();
    }

    public List<Item> getVillagerLikes(Villager villager) {
        return villager.getLikes();
    }

    public List<Item> getVillagerDislikes(Villager villager) {
        return villager.getDislikes();
    }

    public void addVillagerLove(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else if (itemsService.getItemById(item.getId()) != null) {
            List<Item> loves = villager.getLoves();
            loves.add(item);
            villager.setLoves(loves);
            villagerRepository.save(villager);
        } else {
            itemRepository.save(item);
            villager.getLoves().add(item);
            villagerRepository.save(villager);
        }
    }

    public void addVillagerLike(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else if (itemsService.getItemById(item.getId()) != null) {
            List<Item> likes = villager.getLikes();
            likes.add(item);
            villager.setLikes(likes);
            villagerRepository.save(villager);
        } else {
            itemRepository.save(item);
            villager.getLikes().add(item);
            villagerRepository.save(villager);
        }
    }

    public void addVillagerDislike(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else if (itemsService.getItemById(item.getId()) != null) {
            List<Item> dislikes = villager.getDislikes();
            dislikes.add(item);
            villager.setDislikes(dislikes);
            villagerRepository.save(villager);
        } else {
            itemRepository.save(item);
            villager.getDislikes().add(item);
            villagerRepository.save(villager);
        }
    }

    public void removeVillagerLove(Long villagerId, Long itemId) {
        Villager villager = getVillagerById(villagerId);
        Item item = itemsService.getItemById(itemId).orElse(null);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else if (item == null) {
            throw new IllegalArgumentException("Item not found");
        } else {
            List<Item> loves = villager.getLoves();
            loves.remove(item);
            villager.setLoves(loves);
            villagerRepository.save(villager);
        }
    }
}
