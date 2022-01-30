package com.foodDelivery.restaurants.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    private Long foodId;
    private String foodName;
    private String foodDescription;
}
