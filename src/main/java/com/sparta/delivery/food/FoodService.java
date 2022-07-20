package com.sparta.delivery.food;

import com.sparta.delivery.restaurant.Restaurant;
import com.sparta.delivery.restaurant.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodRegisterDto> dtoList) {
//        Long restaurantId = dto.getRestaurantId();
//        String name = dto.getName();
        dtoList.forEach(dto -> {int price = dto.getPrice();
            String name = dto.getName();
            //이름 중복 -> 모든 가게에서 이름 체크
            Optional<Food> found = foodRepository.findByNameAndRestaurantId(name, restaurantId);
            if(found.isPresent()){
                throw new IllegalArgumentException("중복된 음식입니다.");
            }//오류 메세지 처리는 없었는데 아예 중복되지 않게 하는 방법은 없는지? ex)unique
//        if(FoodRepository.findByFoodName(name) != null){
//            throw new IllegalArgumentException("중복된 음식입니다.");
//        }
            if(price < 100 || price > 1000000){
                throw new IllegalArgumentException("100원 이상 100만원 이하로 설정해주세요.");
            }
//        2. 500 원 단위로만 입력 가능 (예. 2,200 원 입력 시 에러발생. 2,500 원 입력 가능)
            if(price % 100 != 0){
                throw new IllegalArgumentException("100원 단위로 입력 가능합니다.");
            }

            Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("잘못된 레스토랑 ID 입니다."));

            Food food = dto.toEntity();
            food.setRestaurant(restaurant);
            foodRepository.save(food);});
    }

    @Transactional
    public List<FoodDto> food(Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(FoodDto::new)
                .collect(Collectors.toList());

    }

    public void deleteAll() {
        foodRepository.deleteAll();
    }
}
