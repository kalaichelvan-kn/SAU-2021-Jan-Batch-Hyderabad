package com.accolite.auspringmvc.controller;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/create/{id}")
    public ResponseEntity<String> createOrder(@PathVariable("id") int orderId){
        String response = orderService.createOrder(orderId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/item/add")
    public ResponseEntity<String> addItem(@PathVariable("id") int orderId, @RequestBody Item item){
        String response = orderService.addItem(orderId, item);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/item/update")
    public ResponseEntity<String> updateItem(@PathVariable("id") int orderId, @RequestBody Item item){
        String response = orderService.updateItem(orderId, item);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{orderId}/item/delete/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("orderId") int orderId, @PathVariable("itemId") int itemId){
        String response = orderService.deleteItem(orderId, itemId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find/{id}")
    public Object getOrder(@PathVariable("id") int orderId){
        Optional<Order> response = orderService.getOrderItems(orderId);
        if(Objects.nonNull(response)){
            return ResponseEntity.ok(response);
        }else{
            return new String("Order not found Id: "+orderId);
        }
    }

}
