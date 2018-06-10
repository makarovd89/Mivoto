package com.herokuapp.mivoto.util;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.to.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantsUtil {
    private RestaurantsUtil(){}

    public static Restaurant fromTo(RestaurantTo restaurant) {
        return new Restaurant(restaurant.getId(), restaurant.getName(), restaurant.getAddress(), restaurant.getPhone());
    }

    public static RestaurantTo asTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getAddress(), restaurant.getPhone());
    }

    public static List<RestaurantTo> asTo(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantsUtil::asTo)
                .collect(Collectors.toList());
    }
}
