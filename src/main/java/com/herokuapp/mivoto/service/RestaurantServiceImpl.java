package com.herokuapp.mivoto.service;

import com.herokuapp.mivoto.model.Restaurant;
import com.herokuapp.mivoto.repository.restaurant.RestaurantRepository;
import com.herokuapp.mivoto.to.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

import static com.herokuapp.mivoto.util.RestaurantsUtil.asTo;
import static com.herokuapp.mivoto.util.ValidationUtil.checkNotFoundWithId;

@Service
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    @CacheEvict(value = "restaurants", allEntries = true)
    @Transactional
    @Override
    public RestaurantTo create(Restaurant restaurant) {
        return asTo(repository.create(restaurant));
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Transactional
    @Override
    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public RestaurantTo get(int id) {
        return asTo(checkNotFoundWithId(repository.get(id),  id));
    }

    @CacheEvict(value = "restaurants", allEntries = true)
    @Transactional
    @Override
    public void update(Restaurant restaurant) {
        checkNotFoundWithId(repository.update(restaurant), restaurant.getId());
    }

    @Override
    public List<RestaurantTo> getAll() {
        return asTo(repository.getAll());
    }

    @Cacheable("restaurants")
    @Override
    public List<Restaurant> getAllWithMenuByDate(LocalDate date) {
        return repository.getAllWithMenuByDate(date);
    }
}
