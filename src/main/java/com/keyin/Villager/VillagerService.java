package com.keyin.Villager;

import java.util.ArrayList;
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
        Villager newVillager = new Villager();
        List <Item> loves = new ArrayList<>();
        List <Item> likes = new ArrayList<>();
        List <Item> dislikes = new ArrayList<>();
        saveItemsIfNotExist(villager.getLoves());
        saveItemsIfNotExist(villager.getLikes());
        saveItemsIfNotExist(villager.getDislikes());
        newVillager.setName(villager.getName());
        newVillager.setBirthday(villager.getBirthday());
        System.out.println(villager.getLoves());
        for (Item item : villager.getLoves()) {
            loves.add(itemRepository.findByName(item.getName()));
        }
        for (Item item : villager.getLikes()) {
            likes.add(itemRepository.findByName(item.getName()));
        }
        for (Item item : villager.getDislikes()) {
            dislikes.add(itemRepository.findByName(item.getName()));
        }
        newVillager.setLoves(loves);
        newVillager.setLikes(likes);
        newVillager.setDislikes(dislikes);
        return villagerRepository.save(newVillager);
    }
    
    private void saveItemsIfNotExist(List<Item> items) {
        if (items != null) {
            for (Item item : items) {
                if (itemRepository.findByName(item.getName()) == null) {

                    itemRepository.save(item);
                }
            }
        }
    }
    public void deleteVillagerById(Long id) {
        Villager villager = getVillagerById(id);
        villagerRepository.delete(villager);
    }

    public Villager updateVillager(Long id, Villager villager) {
        Villager oldVillager = getVillagerById(id);
        if (oldVillager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else {
            oldVillager.setName(villager.getName());
            oldVillager.setBirthday(villager.getBirthday());
            oldVillager.setLoves(villager.getLoves());
            oldVillager.setLikes(villager.getLikes());
            oldVillager.setDislikes(villager.getDislikes());
            return villagerRepository.save(oldVillager);
        }
    }

    public Villager getVillagerById(Long id) {
        return villagerRepository.findById(id).orElse(null);
    }

    public List<Villager> getAllVillagers() {
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
            List<Item> loves = villager.getLoves();
            itemRepository.save(item);
            loves.add(item);
            villager.setLoves(loves);
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
            List<Item> likes = villager.getLikes();
            itemRepository.save(item);
            likes.add(item);
            villager.setLikes(likes);
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
            List<Item> dislikes = villager.getDislikes();
            itemRepository.save(item);
            dislikes.add(item);
            villager.setDislikes(dislikes);
            villagerRepository.save(villager);
        }
    }

    public void removeVillagerLove(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else {
            List<Item> loves = villager.getLoves();
            loves.remove(item);
            villager.setLoves(loves);
            villagerRepository.save(villager);
        }
    }

    public void removeVillagerLike(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else {
            List<Item> likes = villager.getLikes();
            likes.remove(item);
            villager.setLikes(likes);
            villagerRepository.save(villager);
        }
    }


    public void removeVillagerDislike(Long id, Item item) {
        Villager villager = getVillagerById(id);
        if (villager == null) {
            throw new IllegalArgumentException("Villager not found");
        } else {
            List<Item> dislikes = villager.getDislikes();
            dislikes.remove(item);
            villager.setDislikes(dislikes);
            villagerRepository.save(villager);
        }
    }
}
