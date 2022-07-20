package com.sparta.delivery.food;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FoodDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int price;


    public FoodDto(Food food) { //써줘야지 왜 안 썼니....ㅜ
        this.id = food.getId();
        this.name = food.getName();
        this.price = food.getPrice();
    }
}
