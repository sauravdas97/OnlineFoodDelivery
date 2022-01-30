package com.foodDelivery.foodData.ValueObject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantDescription;
    private ArrayList<Long> availableFood;
}
