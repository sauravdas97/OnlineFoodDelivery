package com.foodDelivery.foodData.ValueObject;

import com.foodDelivery.foodData.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
    private Food food;
    private List<Restaurant> restaurantList;
}
