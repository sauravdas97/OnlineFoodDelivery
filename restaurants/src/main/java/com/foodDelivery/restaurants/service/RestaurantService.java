package com.foodDelivery.restaurants.service;

import com.foodDelivery.restaurants.ValueObject.Food;
import com.foodDelivery.restaurants.ValueObject.ResponseTemplate;
import com.foodDelivery.restaurants.entity.Restaurant;
import com.foodDelivery.restaurants.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestTemplate restTemplate;

//    Add restaurants
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

//    Get Restaurant by ID
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).get();
    }

//    Get all restaurants
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    public ResponseTemplate getRestaurantWithFood(Long id) {
        log.info(">>> inside getRestaurantWithFood ");
        Restaurant restaurant = restaurantRepository.findById(id).get();
        List<Long> availableFood =  new ArrayList<>(restaurant.getAvailableFood());
        List<Food> foodList = new ArrayList<>();
        for(Long foodId: availableFood){
            Food food = restTemplate.getForObject("http://FOOD-SERVICE/food/getFoodById/" + foodId, Food.class);
            foodList.add(food);
        }
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setRestaurant(restaurant);
        responseTemplate.setFood(foodList);
        return responseTemplate;
    }
}
