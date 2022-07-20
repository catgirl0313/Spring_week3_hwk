package com.sparta.delivery.food;

import com.sparta.delivery.restaurant.Restaurant;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column
    private String name;

    @Column
    private int price;

    public Food(){
    }

    public Food(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Food(Restaurant restaurant, String name, int price) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
    }

    public Food registerFood(Restaurant restaurant, String name, int price){
        return new Food(restaurant, name, price);
    }
}
