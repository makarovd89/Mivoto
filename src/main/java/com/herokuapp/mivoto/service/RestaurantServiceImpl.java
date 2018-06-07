package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.repository.restaurant.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static com.herokuapp.mivoto.util.ValidationUtil.checkNotFoundWithId;

@Service
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    @Transactional
    @Override
    public Restaurant create(Restaurant restaurant) {
        return repository.create(restaurant);
    }

    @Transactional
    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Restaurant get(int id) {
        Restaurant restaurant = checkNotFoundWithId(repository.get(id),  id);
        return restaurant;
    }

    @Transactional
    @Override
    public void update(Restaurant restaurant) {
        checkNotFoundWithId(repository.update(restaurant), restaurant.getId());
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }
}