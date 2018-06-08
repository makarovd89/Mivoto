package com.herokuapp.mivoto.repository.menu;

import com.herokuapp.mivoto.model.Menu;
import com.herokuapp.mivoto.repository.restaurant.CrudRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Autowired
    private CrudMenuRepository menuRepository;

    @Autowired
    private CrudRestaurantRepository restaurantRepository;

    @Override
    public Menu save(Menu menu, Integer restaurantId) {
        menu.setRestaurant(restaurantRepository.getOne(restaurantId));
        if (menu.isNew()) {
            return menuRepository.save(menu);
        } else{
            return (get(menu.getId()) == null) ? null : menuRepository.save(menu);
        }
    }

    @Override
    public boolean delete(int id) {
        return menuRepository.delete(id) != 0;
    }

    @Override
    public Menu get(int id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu getByRestaurantId(Integer restaurantId, LocalDate date) {
        return menuRepository.getByRestaurantId(restaurantId, date);
    }
}
