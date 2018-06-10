package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.to.RestaurantTo;
import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    RestaurantTo create(Restaurant restaurant);

    void update(Restaurant restaurant);

    void delete(int id);

    RestaurantTo get(int id);

    List<RestaurantTo> getAll();

    List<Restaurant> getAllWithMenuByDate(LocalDate date);
}