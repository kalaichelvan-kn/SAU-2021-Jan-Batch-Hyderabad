package com.accolite.auspringmvc.implement;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    private static HashMap<Integer, Order> orderHashMap = new HashMap<>();

    public boolean checkOrderExists(int orderId){
        return (orderHashMap.containsKey(orderId))?true:false;
    }
    public boolean checkItemInOrderExists(int orderId,int itemId){
        return (orderHashMap.get(orderId).getItemHashMap().containsKey(itemId))?true:false;
    }

    @Override
    public String createOrder(int orderId){
        Order order = new Order();
        order.setOrderId(orderId);
        orderHashMap.put(orderId, order);
        return "Order created Successfully Id : "+order.getOrderId();
    }

    @Override
    public String addItem(int orderId, Item item){
        if(!checkOrderExists(orderId))
            return "Order id "+orderId+" doesn't exist";
        orderHashMap.get(orderId).getItemHashMap().put(item.getItemId(), item);
        return "Item Added successfully orderId: "+orderId+"  itemId: "+item.getItemId();
    }

    @Override
    public String deleteItem(int orderId, int itemId){
        if(!checkOrderExists(orderId))
            return "Order id "+orderId+" doesn't exist";
        if(!checkItemInOrderExists(orderId, itemId))
            return "Item id "+itemId+" doesn't exist is order id : "+orderId;
        orderHashMap.get(orderId).getItemHashMap().remove(itemId);
        return "Item id "+itemId+" deleted from order id : "+orderId;
    }

    @Override
    public String updateItem(int orderId, Item item){
        int itemId = item.getItemId();
        if(!checkOrderExists(orderId))
            return "Order id "+orderId+" doesn't exist";
        if(!checkItemInOrderExists(orderId, itemId))
            return "Item id "+itemId+" doesn't exist is order id : "+orderId;
        orderHashMap.get(orderId).getItemHashMap().put(itemId,item);
        return "Item id "+itemId+" updated from order id : "+orderId;
    }

    @Override
    public Optional<Order> getOrderItems(int orderId){
        Optional<Order> order = null;
        if(!checkOrderExists(orderId))
            return order;
        return Optional.ofNullable(orderHashMap.get(orderId));
    }
}