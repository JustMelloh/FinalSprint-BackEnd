package com.keyin.Item;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {

    @Id
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "item_sequence")
    private Long id;

    private String name;

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
}
