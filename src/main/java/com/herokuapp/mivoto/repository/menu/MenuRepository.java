package com.herokuapp.mivoto.repository.menu;

import com.herokuapp.mivoto.model.Menu;
import java.time.LocalDate;

public interface MenuRepository {
    Menu save(Menu menu, Integer restaurantId);

    boolean delete(int id);

    Menu get(int id);

    Menu getByRestaurantId(Integer restaurantId, LocalDate date);
}