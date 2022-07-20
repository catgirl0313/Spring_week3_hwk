package com.sparta.delivery.food;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRegisterDto> dtos){
      foodService.registerFood(restaurantId, dtos);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> food(@PathVariable Long restaurantId) {
        return foodService.food(restaurantId);
    }

    @GetMapping("/restaurant/foods/deleteAll")
    public void deleteAll() {
        foodService.deleteAll();
    }

}
