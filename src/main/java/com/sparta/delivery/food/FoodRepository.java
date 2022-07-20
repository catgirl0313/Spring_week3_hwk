package com.sparta.delivery.food;
import com.sparta.delivery.food.Food;//?

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;//?

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByRestaurantId(Long restaurantId);

    Optional<Food> findByNameAndRestaurantId(String name, Long restaurantId);
}