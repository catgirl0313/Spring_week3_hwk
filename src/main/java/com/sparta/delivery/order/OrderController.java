package com.sparta.delivery.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderResponseDto registerOrder(@RequestBody OrderRequestDto dto) {
        return orderService.order(dto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> showOrder() {

        return orderService.showOrders();
    }


}

//@RestController
//public class OrderController {
//    private final OrderService orderService;
//
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @PostMapping("/order/request")
////    public OrderResponseDto registerOrder(@RequestBody OrderRequestDto dto){
////        return orderService.order(dto);
////    }
//
//    @GetMapping("/order")
//    public List<OrderResponseDto> showOrder(){
//        return orderService.showOrders();
//    }

