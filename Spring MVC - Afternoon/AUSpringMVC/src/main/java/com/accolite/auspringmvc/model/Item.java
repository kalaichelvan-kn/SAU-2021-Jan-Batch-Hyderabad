package com.accolite.auspringmvc.model;

import java.util.HashMap;

public class Item {
    private int itemId;
    private String name;
    private int quantity;

    public Item(){}
    public Item(int itemId, String name, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
    }
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
