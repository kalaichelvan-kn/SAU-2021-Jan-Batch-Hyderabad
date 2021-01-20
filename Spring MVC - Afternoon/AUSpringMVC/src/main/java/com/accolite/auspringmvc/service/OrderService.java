package com.accolite.auspringmvc.service;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;

import java.util.Optional;

public interface OrderService {
    public String createOrder(int orderId);
    public String addItem(int orderId, Item item);
    public String deleteItem(int orderId, int itemId);
    public String updateItem(int orderId, Item item);
    public Optional<Order> getOrderItems(int orderId);
}
