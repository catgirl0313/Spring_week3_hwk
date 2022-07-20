package com.sparta.delivery.food;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodRegisterDto {
    //음식점 id
//    @NotNull
//    private Long restaurantId;
    @NotNull
    private String name;
    @NotNull
    private int price;

    public Food toEntity() {
        return  new Food(name, price);
    }
}

