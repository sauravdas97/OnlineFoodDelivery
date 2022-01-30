package com.foodDelivery.foodData.service;

import com.foodDelivery.foodData.ValueObject.ResponseTemplate;
import com.foodDelivery.foodData.ValueObject.Restaurant;
import com.foodDelivery.foodData.entity.Food;
import com.foodDelivery.foodData.repository.FoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFood() {
        return new ArrayList<>(foodRepository.findAll());
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).get();
    }

    public ResponseTemplate getFoodWithRestaurant(Long foodId) {
        log.info("Inside getFoodWithRestaurant");
        Food food = foodRepository.findById(foodId).get();

        Restaurant[] restaurants = restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurants/allRestaurant", Restaurant[].class);

        assert restaurants != null;
        List<Restaurant> restaurantList = Arrays.stream(restaurants).filter(r -> r.getAvailableFood().contains(foodId)).collect(Collectors.toList());

        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setFood(food);
        responseTemplate.setRestaurantList(restaurantList);

        return responseTemplate;
    }
}
