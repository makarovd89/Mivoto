package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Menu;
import com.herokuapp.mivoto.repository.menu.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

import static com.herokuapp.mivoto.util.ValidationUtil.checkNotFound;
import static com.herokuapp.mivoto.util.ValidationUtil.checkNotFoundWithId;

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository repository;

    @Override
    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public Menu create(Menu menu, int restaurantId) {
        return repository.save(menu, restaurantId);
    }

    @Override
    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public void update(Menu menu, int restaurantId) {
        checkNotFoundWithId(repository.save(menu, restaurantId), menu.getId());
    }

    @Override
    @Transactional
    @CacheEvict(value = "restaurants", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Menu get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public Menu get(LocalDate date, Integer restaurantId) {
        Menu menu = repository.getByRestaurantId(restaurantId, date);
        checkNotFound(menu!=null, String.format("restaurantId: %d, for date: %tF", restaurantId, date));
        return menu;
    }
}
