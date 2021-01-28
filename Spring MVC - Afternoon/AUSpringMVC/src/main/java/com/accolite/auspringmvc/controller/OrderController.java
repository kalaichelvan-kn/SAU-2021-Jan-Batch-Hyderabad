package com.accolite.auspringmvc.controller;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/create/{id}")
    @ApiOperation(value = "creates order with the input Order id", notes = "integer input order id")
    public ResponseEntity<Object> createOrder(@PathVariable("id") int orderId){
        String response = orderService.createOrder(orderId);
        Map<String, String> obj = new HashMap<>();
        obj.put("result","200");
        obj.put("data",response);
        return ResponseEntity.ok(obj);
    }
    @PostMapping("/{id}/item/add")
    public ResponseEntity<Object> addItem(@PathVariable("id") int orderId, @RequestBody Item item){
        String response = orderService.addItem(orderId, item);
        Map<String, String> obj = new HashMap<>();
        obj.put("result","200");
        obj.put("data",response);
        return ResponseEntity.ok(obj);
    }
    @PostMapping("/{id}/item/update")
    public ResponseEntity<Object> updateItem(@PathVariable("id") int orderId, @RequestBody Item item){
        String response = orderService.updateItem(orderId, item);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{orderId}/item/delete/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable("orderId")  int orderId, @PathVariable("itemId") int itemId){
        String response = orderService.deleteItem(orderId, itemId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") int orderId){
        Optional<Order> response = orderService.getOrderItems(orderId);
        Map<String, Object> obj = new HashMap<>();
        if(Objects.nonNull(response)){
            obj.put("result","200");
            obj.put("data",response);
            return ResponseEntity.ok(obj);
        }else{
            obj.put("result","404");
            obj.put("data","Order not found"+orderId);
            return ResponseEntity.ok(obj);
        }
    }

}
