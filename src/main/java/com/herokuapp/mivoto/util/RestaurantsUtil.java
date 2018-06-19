package com.herokuapp.mivoto.util;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.to.MenuTo;
import com.herokuapp.mivoto.to.RestaurantTo;
import com.herokuapp.mivoto.to.RestaurantWithMenuTo;
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

    public static RestaurantWithMenuTo asToWithMenu(Restaurant restaurant) {
        return new RestaurantWithMenuTo(asTo(restaurant), getMenuToIfExists(restaurant));
    }

    public static List<RestaurantWithMenuTo> asToWithMenu(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantsUtil::asToWithMenu)
                .collect(Collectors.toList());
    }

    private static MenuTo getMenuToIfExists(Restaurant restaurant){
        return restaurant.getMenu()
                .stream()
                .findFirst()
                .map(MenuUtil::asTo)
                .orElse(null);
    }
}
