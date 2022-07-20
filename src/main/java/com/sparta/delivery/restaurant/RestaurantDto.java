package com.sparta.delivery.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RestaurantDto {//responsedto

    private Long id;

    //음식점 이름(name)
    private String name;

    //최소주문 가격 (minOrderPrice)
    private int minOrderPrice;

    //기본 배달비 (deliveryFee)
    private int deliveryFee;

    public RestaurantDto(Restaurant entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.minOrderPrice = entity.getMinOrderPrice();
        this.deliveryFee = entity.getDeliveryFee();
    } //to DTO  entity -> dto
}
