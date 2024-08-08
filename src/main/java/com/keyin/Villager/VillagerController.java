package com.keyin.Villager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/villager")
@CrossOrigin
public class VillagerController {
    @Autowired
    private VillagerService villagerService;

    @GetMapping("/all")
    public List<Villager> getAllVillagers() {
        return villagerService.getAllVillagers();
    }

    @PostMapping("/add")
    public String addVillagers(@RequestBody Villager villager) {
        villagerService.saveVillager(villager);
        return "Villager added successfully";
    }

    @GetMapping("/{id}")
    public Villager getVillagerById(@PathVariable Long id) {
        return villagerService.getVillagerById(id);
    }

    @GetMapping("/search/{name}")
    public Villager searchForVillager(@PathVariable String name) {
        return villagerService.getVillagerByName(name);
    }
    

    @PutMapping("/{id}")
    public String updateVillager(@PathVariable Long id, @RequestBody Villager Villager) {
        villagerService.updateVillager(id, Villager);
        return "Villager updated successfully";
    }
}
