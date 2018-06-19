package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.to.RestaurantTo;
import com.herokuapp.mivoto.to.RestaurantWithMenuTo;
import java.time.LocalDate;
import java.util.List;

public interface RestaurantService {
    RestaurantTo create(Restaurant restaurant);

    void update(Restaurant restaurant);

    void delete(int id);

    RestaurantTo get(int id);

    List<RestaurantTo> getAll();

    List<RestaurantWithMenuTo> getAllWithMenuByDate(LocalDate date);

    List<RestaurantWithMenuTo> getAllOnlyWithMenuByDate(LocalDate date);
}