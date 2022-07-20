package com.sparta.delivery.order;

import com.sparta.delivery.food.Food;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;

    public OrderFood(){
    }

    public OrderFood(Food food, Order order, int quantity) {
        this.food = food;
        this.order = order;
        this.quantity = quantity;
    }



}
