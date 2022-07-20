package com.sparta.delivery.restaurant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public static final int MIN_ORDER_PRICE = 1000;
    public static final int MAX_ORDER_PRICE = 100000;
    public static final int MIN_DELIVERY_FEE = 0;
    public static final int MAX_DELIVERY_FEE = 10000;

    //% 100 != 0

//        1. 음식점 이름 (name)
//        2. 최소주문 가격 (minOrderPrice)
//            1. 허용값: 1,000 원 ~100,000 원 입력
//            2. 100 원 단위로만 입력 가능 (예. 2,220 원 입력 시 에러발생. 2,300 원은 입력 가능)
//            3. 허용값이 아니거나 100 원 단위 입력이 아닌 경우 에러 발생시킴
//        3. 기본 배달비 (deliveryFee)
//                1. 허용값: 0 원 ~10, 000 원(예. 11, 000원 입력 시 에러발생.)
//        2. 500 원 단위로만 입력 가능 (예. 2,200 원 입력 시 에러발생. 2,500 원 입력 가능)

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant registerRestaurant(RestaurantRegisterDto dto) {
//        String name = dto.getName();
        int minOrderPrice = dto.getMinOrderPrice();
        int deliveryFee = dto.getDeliveryFee();

//        1. 허용값: 1,000 원 ~100,000 원 입력
        //(minOrderPrice < 10 || minOrderPrice > 100000)
        if(minOrderPrice < MIN_ORDER_PRICE || minOrderPrice > MAX_ORDER_PRICE) {
            throw new IllegalArgumentException(MIN_ORDER_PRICE + "원 이상," + MAX_ORDER_PRICE + "원 이하로 설정해 주세요.");
        }
        //% 100 != 0
//        2. 100 원 단위로만 입력 가능 (예. 2,220 원 입력 시 에러발생. 2,300 원은 입력 가능)
        if(minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력 가능합니다.");
        }

//        1. 허용값: 0 원 ~10, 000 원(예. 11, 000원 입력 시 에러발생.)
        if(deliveryFee < MIN_DELIVERY_FEE || deliveryFee > MAX_DELIVERY_FEE){
            throw new IllegalArgumentException(MIN_DELIVERY_FEE + "원 이상," + MAX_DELIVERY_FEE + "원 이하로 설정해 주세요.");
        }
//        2. 500 원 단위로만 입력 가능 (예. 2,200 원 입력 시 에러발생. 2,500 원 입력 가능)
        if(deliveryFee % 500 != 0){
            throw new IllegalArgumentException("500원 단위로 입력해주세요.");
        }

        Restaurant restaurant = dto.toEntity(); // id값 없음
        Restaurant restaurant1 = new Restaurant(dto);//entity생성자 가져와서 dto를 넣어줘
//        Restaurant restaurant = new Restaurant(dto);//entity생성자 가져와서 dto를 넣어줘
        return restaurantRepository.save(restaurant1); //id값 있음

    }

    public List<RestaurantDto> restaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(RestaurantDto::new)
                .collect(Collectors.toList());
    }
}
