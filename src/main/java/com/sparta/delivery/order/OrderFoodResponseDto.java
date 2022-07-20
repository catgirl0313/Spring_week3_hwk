package com.sparta.delivery.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class OrderFoodResponseDto {
    private String name;
    private int quantity;

    //음식금액 * queantity
    private int price;

    public OrderFoodResponseDto(String name, int quantity, int price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }



}
