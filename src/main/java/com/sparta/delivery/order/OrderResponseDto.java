package com.sparta.delivery.order;

import lombok.*;

import java.util.List;

@Data
public class OrderResponseDto {
    private String restaurantName;
    private List<OrderFoodResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;

}
