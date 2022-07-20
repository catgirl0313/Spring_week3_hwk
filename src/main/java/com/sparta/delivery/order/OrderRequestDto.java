package com.sparta.delivery.order;

import com.sparta.delivery.food.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


//@NoArgsConstructor
//@AllArgsConstructor
//@Data

@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<OrderFoodDto> foods;
//    private List<OrderFoodsRequestDto> foods;
//    private int x;
//    private int y;


}
