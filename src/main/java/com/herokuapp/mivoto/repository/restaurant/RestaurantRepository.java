package com.herokuapp.mivoto.repository.restaurant;

import com.herokuapp.mivoto.model.Restaurant;
import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository {
    Restaurant create(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithMenuByDate(LocalDate date);
}
