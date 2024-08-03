package com.keyin.Villager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Villager {

    @Id
    @SequenceGenerator(name = "villager_sequence", sequenceName = "villager_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "villager_sequence")
    private Long id;

    private String name;

    private String birthday;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
