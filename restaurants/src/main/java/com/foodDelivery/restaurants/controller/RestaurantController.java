package com.foodDelivery.restaurants.controller;

import com.foodDelivery.restaurants.ValueObject.ResponseTemplate;
import com.foodDelivery.restaurants.entity.Restaurant;
import com.foodDelivery.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/getRestaurantById/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/allRestaurant")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/getRestaurantWithFood/{id}")
    public ResponseTemplate getRestaurantWithFood(@PathVariable Long id) {
        return restaurantService.getRestaurantWithFood(id);
    }
}
