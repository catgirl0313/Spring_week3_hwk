package com.sparta.delivery.restaurant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//DB한테 시킴.
    private Long id;

    //음식점 이름(name)
    private String name;

    //최소주문 가격 (minOrderPrice)
    private int minOrderPrice;

    //기본 배달비 (deliveryFee)
    private int deliveryFee;


    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;

//    public Restaurant(String name, int minOrderPrice, int deliveryFee){
//        this.name = name;
//        this. minOrderPrice = minOrderPrice;
//        this. deliveryFee = deliveryFee;
//    }

    //    public Restaurant(String name, int minOrderPrice, int deliveryFee) {
//    }
    public Restaurant(RestaurantRegisterDto dto) {
        this.name = dto.getName();
        this.minOrderPrice = dto.getMinOrderPrice();
        this.deliveryFee = dto.getDeliveryFee();
    }


    public Restaurant(String name, int minOrderPrice, int deliveryFee) {
    }

    public Restaurant() {

    }
}
