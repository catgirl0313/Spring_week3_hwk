package com.sparta.delivery.restaurant;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //음식점 등록(정보 입력받아)
//    @PostMapping("/restaurant/register")
//    public ResponseEntity<HttpStatus> registerRestaurant(@RequestBody RestaurantRegisterDto dto) {
//        restaurantService.registerRestaurant(dto);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRegisterDto dto) {
        return restaurantService.registerRestaurant(dto);
    }
    //음식점 조회(등록된 모든 음식점 정보 조회 가능)
//    1. 등록 시 입력한 음식점 정보 (name, minOrderPrice, deliveryFee)
//    2. DB 테이블 ID (id)

    @GetMapping("/restaurants")
    public List<RestaurantDto> restaurants() {
        return restaurantService.restaurants();
    }
}
