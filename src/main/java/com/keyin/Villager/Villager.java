package com.keyin.Villager;

import java.util.List;

import com.keyin.Item.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Villager {

    @Id
    @SequenceGenerator(name = "villager_sequence", sequenceName = "villager_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "villager_sequence")
    private Long id;

    private String name;

    private String birthday;

    @ManyToMany
    private List<Item> loves;
    @ManyToMany
    private List<Item> likes;
    @ManyToMany
    private List<Item> dislikes;

    public Villager(String name, String birthday, List<Item> loves, List<Item> likes, List<Item> dislikes) {
        this.name = name;
        this.birthday = birthday;
        this.loves = loves;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Villager() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<Item> getLoves() {
        return loves;
    }

    public List<Item> getLikes() {
        return likes;
    }

    public List<Item> getDislikes() {
        return dislikes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setLoves(List<Item> loves) {
        this.loves = loves;
    }

    public void setLikes(List<Item> likes) {
        this.likes = likes;
    }

    public void setDislikes(List<Item> dislikes) {
        this.dislikes = dislikes;
    }
}
