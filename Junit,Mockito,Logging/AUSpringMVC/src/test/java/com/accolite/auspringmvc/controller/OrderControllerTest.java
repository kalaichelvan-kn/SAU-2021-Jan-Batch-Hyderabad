package com.accolite.auspringmvc.controller;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    OrderController orderController;
    @Mock
    OrderService orderService;

    @Nested
    class createOrder{
        public String invalidString = "Invalid Details";
        @Test
        void createOrder() throws Exception {
            int id = 1;
            String result = "Order created Successfully Id : "+String.valueOf(id);
            Mockito.when(orderService.createOrder(id)).thenReturn(result);
            ResponseEntity<String> response = orderController.createOrder(id);
            Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
            Assertions.assertEquals(200, response.getStatusCodeValue());
            Assertions.assertEquals(response.getBody(),result);
        }
        @Test
        void createOrder_InvalidOrderId() throws Exception {
            int id = 0;
            ResponseEntity<String> response = orderController.createOrder(id);
            Assertions.assertEquals(response.getBody(),invalidString);
            response = orderController.createOrder(id);
            Assertions.assertEquals( response.getBody(), invalidString);
        }
    }

    @Nested
    class addItem{
        public String invalidString = "Invalid Details";
        public int orderId = 1, itemId = 1;
        public String result = "Item Added successfully orderId: "+orderId+"  itemId: "+itemId;
        @Test
        void addItem(){
            Item item = new Item();
            item.setItemId(itemId); item.setName("horlicks"); item.setQuantity(12);
            Mockito.when(orderService.addItem(orderId, item)).thenReturn(result);
            ResponseEntity<String> response = orderController.addItem(orderId, item);
            Assertions.assertEquals(response.getBody(),result);
        }
        @Test
        void invalid_addItem(){
            Item item = new Item();
            item.setItemId(itemId); item.setName("12"); item.setQuantity(12);
            ResponseEntity<String> response = orderController.addItem(orderId, item);
            Assertions.assertEquals(response.getBody(),invalidString);
        }
    }

    @Nested
    class updateItem{
        public String invalidString = "Invalid Details";
        public int orderId = 1, itemId = 1;
        public String result = "Item id "+itemId+" updated from order id : "+orderId;
        @Test
        void updateItem(){
            Item item = new Item();
            item.setItemId(itemId); item.setName("horlicks"); item.setQuantity(12);
            Mockito.when(orderService.updateItem(orderId, item)).thenReturn(result);
            ResponseEntity<String> response = orderController.updateItem(orderId, item);
            Assertions.assertEquals( response.getBody(), result);
        }
        @Test
        void invalid_updateItem(){
            Item item = new Item();
            item.setItemId(itemId); item.setName("41213"); item.setQuantity(-1);
            ResponseEntity<String> response = orderController.updateItem(orderId, item);
            Assertions.assertEquals( response.getBody(), invalidString);
        }
    }

    @Nested
    class deleteItem{
        public int orderId = 1, itemId = 1;
        public String result = "Item id "+itemId+" deleted from order id : "+orderId;
        public String invalidString = "Invalid Details";
        @Test
        void deleteItem(){
            Mockito.when(orderService.deleteItem(orderId, itemId)).thenReturn(result);
            ResponseEntity<String> response = orderController.deleteItem(orderId, itemId);
            Assertions.assertEquals( response.getBody(), result);
        }
        @Test
        void invalid_deleteItem(){
            itemId = 0; orderId = 0;
            ResponseEntity<String> response = orderController.deleteItem(orderId, itemId);
            Assertions.assertEquals( response.getBody(), invalidString);
        }
    }

    @Nested
    class getOrder{
        public int orderId = 1, itemId = 1;
        public String result = "Item id "+itemId+" deleted from order id : "+orderId;
        public String invalidString = "Invalid Details";
        @Test
        void getOrder() {
            Optional<Order> order = Optional.of(new Order());
            Mockito.when(orderService.getOrderItems(orderId)).thenReturn(order);
            ResponseEntity<Object> response = orderController.getOrder(orderId);
            Assertions.assertEquals( response.getBody().getClass(), order.getClass());
        }
        @Test
        void notFound_getOrderItems() {
            String notFoundRes = "Order not found Id: "+orderId;
            Optional<Order> order = null;
            Mockito.when(orderService.getOrderItems(orderId)).thenReturn(order);
            ResponseEntity<Object> response = orderController.getOrder(orderId);
            Assertions.assertEquals( response.getBody(), notFoundRes);
        }
        @Test
        void invalid_getOrderItems() {
            orderId = -12;
            ResponseEntity<Object> response = orderController.getOrder(orderId);
            Assertions.assertEquals( response.getBody(), invalidString);
        }
    }
}