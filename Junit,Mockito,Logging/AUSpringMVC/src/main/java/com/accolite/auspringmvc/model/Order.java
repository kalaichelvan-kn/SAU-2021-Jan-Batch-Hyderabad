package com.accolite.auspringmvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private int orderId;
    private HashMap<Integer, Item> itemHashMap = new HashMap<>();

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public HashMap<Integer, Item> getItemHashMap() {
        return itemHashMap;
    }

    public void setItemHashMap(HashMap<Integer, Item> itemHashMap) {
        this.itemHashMap = itemHashMap;
    }
}
