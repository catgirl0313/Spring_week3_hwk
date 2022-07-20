package com.sparta.delivery.restaurant;

import com.sparta.delivery.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.*;

@Data
public class RestaurantRegisterDto {//requestdto
        @NotNull
        private String name;
        @NotNull
        private int minOrderPrice;
        @NotNull
        private int deliveryFee;

//    public Restaurant toEntity() {
//    }

        public Restaurant toEntity() {
                return new Restaurant(name, minOrderPrice, deliveryFee);
        }
}
