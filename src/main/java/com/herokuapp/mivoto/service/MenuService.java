package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Menu;
import java.time.LocalDate;

public interface MenuService {
    Menu create(Menu menu, int restaurantId);

    void update(Menu menu, int restaurantId);

    void delete(int id);

    Menu get(int id);

    Menu get(LocalDate date, Integer restaurantId);
}
