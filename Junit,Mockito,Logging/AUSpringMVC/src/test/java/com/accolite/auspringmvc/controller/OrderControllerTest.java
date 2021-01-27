package com.accolite.auspringmvc.controller;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @InjectMocks
    OrderController orderController;
    @Mock
    OrderService orderService;

    @Test
    void createOrder() throws Exception {
        int id = 1;
        String result = "Order created Successfully Id : "+String.valueOf(id);
        Mockito.when(orderService.createOrder(id)).thenReturn(result);
        ResponseEntity<String> response = orderController.createOrder(id);
        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(response.getBody(),"Order created Successfully Id : "+String.valueOf(id));
    }

    @Test
    void createOrder_InvalidOrderId() throws Exception {
        int id = 0;
        String result = "Order created Successfully Id : "+String.valueOf(id);
        Assertions.assertThrows(Exception.class, ()-> orderController.createOrder(id));
    }
}