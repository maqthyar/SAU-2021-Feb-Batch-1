package com.assignment.fixerror;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "itemid")
    private int itemId;
    @Column(name = "itemname", length = 10)
    private String itemName;
    @ManyToMany(targetEntity = Categories.class)
    @JoinColumn(referencedColumnName = "itemid")
    private Set<Categories> categories;

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}