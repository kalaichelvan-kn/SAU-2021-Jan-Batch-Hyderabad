package com.accolite.auspringmvc.controller;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/create/{id}")
    public ResponseEntity<String> createOrder(@PathVariable("id") @NotNull int orderId){
        if ( orderId < 1 ) {
            logger.error("order id invalid");
            return ResponseEntity.ok("Invalid Details");
        }
        String response = orderService.createOrder(orderId);
        logger.info("order created success "+orderId+" : "+orderId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/item/add")
    public ResponseEntity<String> addItem(@PathVariable("id") @NotNull int orderId, @RequestBody @Valid Item item){
        if(item.getItemId()<1 || !StringUtils.isAlpha(item.getName()) || item.getQuantity()<1){
            logger.error("order id or item details invalid");
            return ResponseEntity.ok("Invalid Details");
        }
        String response = orderService.addItem(orderId, item);
        logger.info("added success "+orderId+" : "+item.getItemId());
        return ResponseEntity.ok(response);
    }
    @PostMapping("/{id}/item/update")
    public ResponseEntity<String> updateItem(@PathVariable("id") @NotNull int orderId, @RequestBody @Valid Item item) {
        if( item.getItemId()<1 || !StringUtils.isAlpha(item.getName()) || item.getName().length()<1 || item.getQuantity()<1 ){
            logger.error("order id or item details invalid");
            return ResponseEntity.ok("Invalid Details");
        }
        String response = orderService.updateItem(orderId, item);
        logger.info("updated success "+orderId+" : "+item.getItemId());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{orderId}/item/delete/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("orderId") @NotNull int orderId, @PathVariable("itemId") @NotNull int itemId){
        if( itemId<1 || orderId<1 ){
            logger.error("order id or item id invalid");
            return ResponseEntity.ok("Invalid Details");
        }
        String response = orderService.deleteItem(orderId, itemId);
        logger.info("deleted success "+orderId+" : "+itemId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") @NotNull int orderId){
        if( orderId<1 ) {
            logger.error("order id invalid");
            return ResponseEntity.ok("Invalid Details");
        }
        Optional<Order> response = orderService.getOrderItems(orderId);
        if(Objects.nonNull(response)){
            logger.warn("returned order object");
            return ResponseEntity.ok(response);
        }else{
            logger.info("order object not found");
            return ResponseEntity.ok("Order not found Id: "+orderId);
        }
    }
}
