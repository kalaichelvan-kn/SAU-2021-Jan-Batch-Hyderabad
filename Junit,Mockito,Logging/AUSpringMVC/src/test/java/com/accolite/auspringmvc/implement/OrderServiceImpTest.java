package com.accolite.auspringmvc.implement;

import com.accolite.auspringmvc.model.Item;
import com.accolite.auspringmvc.model.Order;
import com.accolite.auspringmvc.service.OrderService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

class OrderServiceImpTest {
    Order order = new Order();
    Item item = new Item();
    OrderService orderService = new OrderServiceImp();

    @Nested
    class createOrder{
        @Test
        void createOrder() {
            int id = 1;
            String res = orderService.createOrder(id);
            Assertions.assertEquals(res, "Order created Successfully Id : "+id);
        }
    }

    @Nested
    class addItem{
        @Test
        void addItem() {
            int id = 1; item.setItemId(1); item.setName("horlicks"); item.setQuantity(12);
            String res1 = orderService.addItem(id, item);
            Assertions.assertEquals(res1, "Order id "+id+" doesn't exist");

            String rest = orderService.createOrder(id);
            String res2 = orderService.addItem(id, item);
            Assertions.assertEquals(res2, "Item Added successfully orderId: "+id+"  itemId: "+item.getItemId());
        }
    }

    @Nested
    class deleteItem{
        @Test
        void deleteItem() {
            int id = 1; item.setItemId(1); item.setName("horlicks"); item.setQuantity(12);
            String res1 = orderService.deleteItem(id, item.getItemId());

            String rest = orderService.createOrder(id);
            String res2 = orderService.deleteItem(id, item.getItemId());

            rest = orderService.addItem(id, item);
            String res3 = orderService.deleteItem(id, item.getItemId());

            Assertions.assertEquals(res1, "Order id "+id+" doesn't exist");
            Assertions.assertEquals(res2, "Item id "+item.getItemId()+" doesn't exist is order id : "+id);
            Assertions.assertEquals(res3, "Item id "+item.getItemId()+" deleted from order id : "+id);
        }
    }

    @Nested
    class updateItem{
        @Test
        void updateItem() {
            int id = 1; item.setItemId(1); item.setName("horlicks"); item.setQuantity(12);
            String res1 = orderService.updateItem(id, item);
            Assertions.assertEquals(res1, "Order id "+id+" doesn't exist");

            String rest = orderService.createOrder(id);
            String res2 = orderService.updateItem(id, item);
            Assertions.assertEquals(res2, "Item id "+item.getItemId()+" doesn't exist is order id : "+id);

            rest = orderService.addItem(id, item);
            String res3 = orderService.updateItem(id, item);
            Assertions.assertEquals(res3, "Item id "+item.getItemId()+" updated from order id : "+id);
        }
    }

    @Nested
    class getOrder{
        @Test
        void getOrderItems() {
            int id = 1;
            Optional<Order> res = orderService.getOrderItems(id);
            Assertions.assertEquals( res, null);
            String rest = orderService.createOrder(id);
            res = orderService.getOrderItems(id);
            Assertions.assertEquals(res.get().getClass(), Order.class);
        }
    }

}