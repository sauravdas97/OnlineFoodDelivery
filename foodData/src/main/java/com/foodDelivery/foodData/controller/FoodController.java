package com.foodDelivery.foodData.controller;

import com.foodDelivery.foodData.ValueObject.ResponseTemplate;
import com.foodDelivery.foodData.entity.Food;
import com.foodDelivery.foodData.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/addFood")
    public Food addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @GetMapping("/getAllFood")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping("/getFoodById/{id}")
    public Food getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id);
    }

    @GetMapping("/getFoodWithRestaurant/{foodId}")
    public ResponseTemplate getFoodWithRestaurant(@PathVariable Long foodId) {
        return foodService.getFoodWithRestaurant(foodId);
    }
}
