# SAU-2021-Jan-Batch-Hyderabad

## Spring MVC - Junit Mockito Logging - kalai.chelvan@accolitedigital.com

### sample controller code

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

### sample test code 

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

### screenshots

![sc1](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Junit,Mockito,Logging/ctrl.PNG)
![sc2](https://raw.githubusercontent.com/kalaichelvan-kn/SAU-2021-Jan-Batch-Hyderabad/main/Junit,Mockito,Logging/serv.PNG)

## end